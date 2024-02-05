# SwagLabsBDD
Napisany kod autoamtyzacji, który ma na celu sprawdzenie:
1. Logowanie wyszystkich dostępnych użytkowników
2. Zalogowany użytkownik dodaje wszystkie dostępne produkty do koszyka
3. Użytkownk z wszystkimi produktami kończy proces zamawiania
 
 Rezultaty 1: Tylko użytkownik locked_out_user nie może się zalogować
 <br/>
<br/>Rezultaty 2: Uzytkownicy problem_user oraz error_user nie mogą dodać wszystkich przedmiotów do koszyka. 
W obu przypadkach przycisk &nbsp; "add to cart" nie wykonuje akcji
<br/>
<br/>Rezultaty 3: Użytkownicy którzy są w stanie dodać wszystkie produkty do karty są w stanie zakończyć zamówienie
<br/><br/>Uwagi do błędnych uzytkowników:
<br/>
1. locked_out_user:
   * Dostaje komunikat: Epic sadface: Sorry, this user has been locked out.
3. problem_user:
   * Zdjęcia produktów są jako psy
   * W polu od danych zamówenia "Last Name" napisuje "First Name"
   * Brak możliwości dokończenia zamówienia ponieważ Error: Last Name is required
5. error_user:
   * W polu od danych zamówenia "Last Name" nie da się wpisać zawartości
   * Mimo braku Last Name możemy przejść dalej
   * Przycisk "Finish" kliknięcie nie wywołuje akcji
