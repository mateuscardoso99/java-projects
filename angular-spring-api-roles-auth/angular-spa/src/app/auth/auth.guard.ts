//guards são interfaces que retornam um Promise< boolean >, Observable< boolean >, 
//um boolean ou um UrlTree. 
//Existem vários tipos de guardas: 
//CanActivate -Controla o acesso a uma rota. 
//CanActivateChild - Controla o acesso a uma rota filho.
//CanDeactivate - Media a navegação longe da rota atual. 
//Resolver - Execute a recuperação de dados da rota antes da ativação da rota. 
//CanLoad - Mediate a navegação para um módulo de recurso carregado de forma assíncrona.

//gerar guarda
//-ng generate guard [nome_pasta/nome_arquivo]

import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, Router, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { StorageService } from '../_services/storage.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private storageService: StorageService, private router: Router) {}
  
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (!this.storageService.isLoggedIn()) {
      this.router.navigate(['/login']); // go to login if not authenticated
      return false;
    }
    return true;
  }
  
}
