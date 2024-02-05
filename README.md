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
