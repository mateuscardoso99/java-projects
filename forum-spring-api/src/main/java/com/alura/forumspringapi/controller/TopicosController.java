package com.alura.forumspringapi.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.alura.forumspringapi.controller.dto.DetalhesTopicoDto;
import com.alura.forumspringapi.controller.dto.TopicoDto;
import com.alura.forumspringapi.controller.form.AtualizarTopicoForm;
import com.alura.forumspringapi.controller.form.TopicoForm;
import com.alura.forumspringapi.modelo.Topico;
import com.alura.forumspringapi.repository.CursoRepository;
import com.alura.forumspringapi.repository.TopicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")//esse controller responde as requisições em /topicos
public class TopicosController {
    
    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    CursoRepository cursoRepository;



    @GetMapping
    @Cacheable(value = "listaDeTopicos")//habilitando cache para o método com um id listaDeTopicos, o spring salva cache para diferentes query params passados
    /* 
        com paginação e ordenacao ex: http://localhost:8080/topicos?page=0&size=2&sort=id,ASC&sort=dataCriacao,DESC (pode passar multiplos sort para ordenar)
        @RequestParam indica que os parametros do metodo são query params
    */
    public Page<TopicoDto> lista(@RequestParam(required = false) String nome, 
        @PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao){
        //PageableDefault: ordenação, pagina e qtd padrão caso não seja passado nada na url

        //outra forma de fazer: recebendo cada parametro e criando objeto individualmente
        //@RequestParam int pagina, @RequestParam int qtd, @RequestParam String ordenacao
        //Pageable paginacao = PageRequest.of(pagina, qtd, Direction.ASC, ordenacao);
        //Direction.ASC: ordem crescente

        if (nome == null) {
            Page<Topico> topicos = topicoRepository.findAll(paginacao);
            return TopicoDto.converter(topicos);
        } else {
            Page<Topico> topicos = topicoRepository.findByCursoNome(nome, paginacao);
            return TopicoDto.converter(topicos);
        }
    }

    @PostMapping
    @Transactional //comitar a trasacao no final do metodo
    @CacheEvict(value = "listaDeTopicos", allEntries = true) //limpa o cache toda vez que cadastrar um novo registro
    public ResponseEntity<TopicoDto> cadastrar(@Valid @RequestBody TopicoForm dados, UriComponentsBuilder uriBuilder) {
        //@RequestBody: pegar dados do corpo da requisicao

        Topico topico = dados.converter(cursoRepository);
        topicoRepository.save(topico);//repository apenas aceita um objeto do tipo da entidade se não da erro
        
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));

        /**
         * toda vez que devolve 201 para o cliente, além de devolver o código, 
         * tem que devolver mais duas coisas: uma delas é um cabeçalho HTTP, chamado "Location", com a 
         * URL desse novo recurso que acabou de ser criado; a segunda coisa é que, no corpo da resposta, 
         * tem que devolver uma representação desse recurso que foi criado. Então, quando eu chamo o 
         * método created(), ele fica esperando a uri do recurso que criamos para adicioná-la no 
         * cabeçalho Location.
         * Esse uri que ele recebe é a classe URI do Java (vem do pacote java.net). 
         * Mas na hora em que crio um objeto uri, tenho que passar o caminho completo dessa uri: 
         * "http://localhost:8080/topico/id do tópico".
         * No método cadastrar(), estou recebendo o form e posso colocar uma vírgula e depois uma 
         * classe do Spring chamada UriComponentsBuilder. Seguindo, vou chamar esse parâmetro de 
         * uriBuilder. É só declarar o UriComponentsBuilder como parâmetro que o Spring vai injetar 
         * no método para você.
         * Por último .buildAndExpand(), método que temos que chamar, passando como parâmetro um 
         * valor a ser substituído no espaço do {id}, que é dinâmico. No caso, vou puxar o id do 
         * tópico que acabei de criar no banco de dados e ele vai substituir esse {id} e jogar na uri.
         */
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesTopicoDto> detalhar(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(new DetalhesTopicoDto(topico.get()));    
        }
        return ResponseEntity.notFound().build();
    }

    /* ResponseEntity representa toda a resposta HTTP: 
    código de status, 
    cabeçalhos e corpo. 
    Como resultado, podemos usá-lo para configurar totalmente a resposta HTTP. */

    @PutMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaDeTopicos", allEntries = true)
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarTopicoForm form) {
        Optional<Topico> optional = topicoRepository.findById(id);
        if (optional.isPresent()) {
            Topico topico = form.atualizar(id, topicoRepository);
            return ResponseEntity.ok(new TopicoDto(topico));   
        }
        return ResponseEntity.notFound().build();
        
        //não precisa chamar metodo update do jpa pois ele atualiza automaticamente
        //quando ocorre mudanças no objeto Entity
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaDeTopicos", allEntries = true)
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Topico> optional = topicoRepository.findById(id);
        if (optional.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
