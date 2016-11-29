# POO-Tema2
#Autor: Cristian Dutescu
#Grupa: 321CA

Clasa Test
Metoda main a fost implementata in clasa Test. In main citim de la input o comada, apelam CommandFactory pentru a obtine un obiect de comanda ceruta iar apoi apelam metoda execute din obiectul primit.

Interfata Command 
Aceasta interfata este folosita pentru a defini prototipul fiecarei comenzi

CommandFactory
Aceasta clasa contine o metoda ce interpreteaza comanda in format String primita ca parametru si intoarce un obiect de tipul comenzii specificate.

Clasa User
Clasa User defineste un obiect de tipul utilizator

Clasa Fisier
Defineste un obiect de tip fisier

Clasa Director
Aceasta clasa extinde clasa fisier. Un obiect de tipul director contine o lista de obiecte ce pot fi de tipul fisier sau de tipul Director, astfel fiind un CompositePattern

Clasa Bash
Clasa Bash defineste un obiect in care tinem minte directorul si utilizatorul curent, lista de utilizatori din sistem si directorul "/"

Implementarile interfetei Command

Comanda adduser
Adauga un nou utilizator in sistem
Apelare: adduser <username>
Erori posibile:
-10: <command>: No rights to change user status - dacă utilizatorul care adaugă este altul decât root
-9: <command>: User already exists - dacă se încearcă adăugarea unui utilizator care deja există în sistem

Comanda deluser
Sterge un utilizator si schimba owner-ul fiecarui fisier detinut de acest utilizator.
Apelare: deluser <username>
Erori posibile:
-10: <command>: No rights to change user status - dacă utilizatorul care adaugă este altul decât root
-8: <command>: User does not exist - dacă utilizatorul care se dorește a fi șters nu există în sistem

Comanda chuser
Schimba utilizatorul curent si ne muta in directorul home al acestuia.
Apelare: chuser <username>
Erori posibile:
-8: <command>: User does not exist - dacă utilizatorul care se dorește a fi șters nu există în sistem 

Comanda cd
Schimba directorul curent.
Apelare: cd <path>
Erori posibile:
-3: <command>: Not a directory - dacă în calea pe care o precizăm apare la un moment dat un fișier 
-2: <command>: No such directory - dacă în calea pe care o precizăm apare la un moment dat un nume de entitate care nu există
-6: <command>: No rights to execute - dacă nu avem drepturi de a executa pe un director în care dorim să intrăm

Comanda mkdir
Creeaza un nou director.
Apelare: mkdir <path>
Erori posibile:
-1: <command>: Is a directory - dacă noul director ce se dorește a fi creat deja există
-3: <command>: Not a directory - dacă deja există la calea specificată un fișier cu numele pe care dorim să îl dăm directorului
-5: <command>: No rights to write - dacă utilizatorul nu are drept de scriere asupra directorulului în care vrem sa creăm noua entitate 

Comanda ls
Afiseaza continutul unui director, sau un fisier
Apelare: ls <path>
Output: <directory_name> dr-xrw- <owner> 
		<file_name> frwx--- <owner>
Erori posibile:
-12: <command>: No such file or directory - dacă nu va fi găsită nicio enitate la calea specificată
-4: <command>: No rights to read - dacă utilizatorul activ nu are drept de citire asupra entității

Comanda chmod
Schimba permisiunile unui fisier sau drector.
Apelare: chmod <permisiune> <path>
Erori:
-12: <command>: No such file or directory - dacă nu va fi găsită nicio enitate la calea specificată
-5: <command>: No rights to write - dacă utilizatorul curent nu are drept de scriere asupra entității

Comanda touch
Creeaza un nou fisier.
Apelare: touch <path>
Erori posibile:
-1: <command>: Is a directory - dacă un director cu același nume există la calea specificată
-7: <command>: File already exists - dacă un fișier cu același nume există la calea specificată
-5: <command>: No rights to write - dacă utilizatorul activ nu are drept de scriere asupra directorului în care vrem să creăm

Comanda rm
Sterge un fisier sau un director daca este apelata fara paramentru, respectiv cu paramentrul -r
Apelare: rm [-r] <path>
Erori posibile:
-1: <command>: Is a directory - dacă un director cu același nume există la calea specificată
-11: <command>: No such file - dacă la calea specificată nu există fișierul pe care dorim sa îl ștergem
-5: <command>: No rights to write - dacă utilizatorul activ nu are drept de scriere asupra directorului din care vrem sa ștergem

-12: <command>: No such file or directory - dacă la calea specificată nu există entitatea pe care dorim să o ștergem
-13: <command>: Cannot delete parent or current directory - dacă se încearcă ștergerea părintelui, sau a vreunui strămoș (în ierarhia de fișiere), sau a directorului curent
-5: <command>: dacă utilizatorul activ nu are drept de scriere asupra directorului din care vrem sa ștergem

Comanda rmdir
Sterge un director daca acesta e gol.
Apelare: rmdir <path>
Erori posibile:
-3: <command>: Not a directory - dacă deja există la calea specificată un fișier cu numele pe care dorim să îl dăm directorului
-13: <command>: Cannot delete parent or current directory - dacă se încearcă ștergerea părintelui, sau a vreunui strămoș (în ierarhia de fișiere), sau a directorului curent
-14: <command>: Non empty directory - dacă directorul pe care dorim să îl ștergem nu este gol
-5: <command>: No rights to write - dacă utilizatorul activ nu are drept de scriere asupra directorului din care vrem sa ștergem
-2: <command>: No such directory - dacă directorul pe care dorim sa îl ștergem nu se află la calea specificată

Comanda writetofile
Scrie intr-un fisier.
Apelare: writetofile <path> <content>
Erori posibile:
-1: <command>: Is a directory - dacă un director cu același nume există la calea specificată
-11: <command>: No such file - dacă la calea specificată nu există fișierul pe care dorim sa îl ștergem
-5: <command>: No rights to write - dacă utilizatorul activ nu are drept de scriere asupra fișierului

Comanda cat
Afiseaza continutul unui fisier
Apelare: cat <path>
Erori posibile:
-1: <command>: Is a directory - dacă un director cu același nume există la calea specificată
-11: <command>: No such file - dacă la calea specificată nu există fișierul pe care dorim să îl citim
-4: <command>: No rights to read - dacă utilizatorul activ nu are drept de citire asupra fișierului


