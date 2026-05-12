package com.example.techcorp;

/*
 * Ćwiczenie 5 :
 *
 * Pytanie: Dlaczego rozwiązanie oparte na dziedziczeniu jest lepsze
 * od pojedynczej klasy Employee z polem role i instrukcjami if/else?
 *
 * Odpowiedź:
 *
 * Rozwiązanie z jedną klasą Employee i instrukcjami if/else ma kilka
 * poważnych wad. Po pierwsze, klasa zaczyna łączyć w sobie logikę
 * wielu różnych ról, co sprawia że jest trudna do czytania i rozumienia.
 * Po drugie, każde dodanie nowej roli (np. Intern) wymaga modyfikacji
 * istniejącej metody work() – czyli zmieniamy kod który już działał,
 * co może wprowadzić nowe błędy.
 *
 * Dziedziczenie rozwiązuje te problemy. Każda rola ma swoją własną klasę
 * (Developer, Tester, Manager, Intern) z własną implementacją metody work().
 * Dodanie nowej roli oznacza tylko stworzenie nowego pliku – nie dotykamy
 * istniejącego kodu. Klasy Project i Company w ogóle nie muszą wiedzieć
 * jaki typ pracownika obsługują – wystarczy im typ ogólny Employee.
 */

public class Cwiczenie5 {
    // – brak logiki do uruchomienia, tylko odpowiedz na zadanie.
}