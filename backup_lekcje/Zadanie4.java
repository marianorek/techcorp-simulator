package com.example.techcorp;

/*
 * Zadanie 4 – dla ambitnych 
 * Pytanie: Które elementy modelu należą do wspólnej abstrakcji pracownika,
 * a które powinny pozostać w klasach szczegółowych?
 *
 * Elementy wspólne (należą do klasy Employee):
 * - name – każdy pracownik ma imię
 * - skill – każdy pracownik ma poziom umiejętności
 * - salary – każdy pracownik ma wynagrodzenie
 * - getRoleName() – każdy pracownik ma rolę, choć różną
 * - introduceYourself() – każdy pracownik może się przedstawić
 * - work() – każdy pracownik wykonuje pracę, choć w różny sposób
 *
 * Elementy szczegółowe (należą do klas potomnych):
 * - mainLanguage – tylko Developer ma główny język programowania
 * - automationLevel – tylko Tester ma poziom automatyzacji testów
 * - konkretna implementacja work() – każda rola pracuje inaczej
 * - konkretna implementacja introduceYourself() – każda rola przedstawia
 *   się inaczej, ujawniając swoje specyficzne cechy
 */

public class Zadanie4 {
    //  – brak logiki do uruchomienia, tylko odpowiedz na zadanie.
}