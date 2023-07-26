import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'portfolio-for-enterprise';
  src: boolean = true;

  changeLanguage(language: string) {
    // Ajoutez ici la logique pour changer la langue de l'application selon la sélection.
    // Vous pouvez utiliser une bibliothèque de traduction ou simplement modifier une variable globale pour la langue.
    // Par exemple, vous pouvez utiliser un service pour gérer les traductions et stocker la langue sélectionnée.
    // Pour cet exemple, nous allons simplement afficher un message dans la console.
    console.log('Langue sélectionnée :', language);
  }
}
