um app que usa XML pra poder renderizar a tela e os dados
e em algum momento se quis usar uma nova biblioteca pra melhorar algo no app
mas o problema é que ela trabalha com JSON e não XML e os dados do app é em XML
a solução poderia ser mexer no código fonte da biblioteca e fazer funcionar com XML mas isso não seria razoável
a solução é usar um adaptador, ele converterá os dados em XML pra JSON pra poder usar a nova biblioteca
precisa então de uma classe que transforme os dados XML em JSON

ADAPTER é um padrão estrutural que permite que objetos com interfaces imcompatíveis colaborem entre si
