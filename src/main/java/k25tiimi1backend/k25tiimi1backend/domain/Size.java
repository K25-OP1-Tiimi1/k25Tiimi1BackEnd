package k25tiimi1backend.k25tiimi1backend.domain;

public enum Size {
    S,
    M,
    L,
    ONE_KG,

    // EI SAA KÄYTTÄÄ TUOTTEITA LUODESSA/LISÄTESSÄ! LISÄTTY KOSKA RAHTI EI MUUTEN KÄYNNISTY
    // syystä tai toisesta, kun Rahti käynnistää appia se haluaa koon MEDIUM M sijasta, vaikka tälläsitä 
    // ei missään tarvita 
    MEDIUM
}
