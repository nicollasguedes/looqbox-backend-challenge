package com.example.looqboxbackendchallenge.utils;

import com.example.looqboxbackendchallenge.entity.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonSorter {

    private List<Pokemon> pokemonList;

    public PokemonSorter(List<Pokemon> pokemonList, int sortType) {
        this.pokemonList = pokemonList;
        if (sortType == 0) {
            mergeSortByAlphabeticalOrderInit(true);
        } else if (sortType == 1) {
            mergeSortByLengthOfNameInit(true);
        } else if (sortType == 2) {
            mergeSortByAlphabeticalOrderInit(false);
        } else if (sortType == 3) {
            mergeSortByLengthOfNameInit(false);
        }
    }

    public void mergeSortByAlphabeticalOrderInit(boolean ascending) {
        mergeSortByAlphabeticalOrder(pokemonList, 0, pokemonList.size() - 1, ascending);
    }

    // Método de ordenação Merge Sort por ordem alfabética
    private void mergeSortByAlphabeticalOrder(List<Pokemon> pokemonList, int left, int right, boolean ascending) {
        if (left < right) {
            int meio = (left + right) / 2;
            mergeSortByAlphabeticalOrder(pokemonList, left, meio, ascending); // Ordena a metade esquerda
            mergeSortByAlphabeticalOrder(pokemonList, meio + 1, right, ascending); // Ordena a metade direita
            mergeByAlphabeticalOrder(pokemonList, left, meio, right, ascending); // Combina as duas metades
        }
    }

    // Método de combinação de duas metades ordenadas por ordem alfabética
    private void mergeByAlphabeticalOrder(List<Pokemon> pokemonList, int left, int meio, int right, boolean ascending) {
        int leftLenght = meio - left + 1;
        int rightLenght = right - meio;

        List<Pokemon> leftList = new ArrayList<>();
        List<Pokemon> rightList = new ArrayList<>();

        for (int i = 0; i < leftLenght; i++) {
            leftList.add(pokemonList.get(left + i));
        }

        for (int j = 0; j < rightLenght
                ; j++) {
            rightList.add(pokemonList.get(meio + 1 + j));
        }

        int i = 0, j = 0, k = left;

        while (i < leftLenght && j < rightLenght
        ) {
            int comparison = compareByName(leftList.get(i), rightList.get(j));
            if ((ascending && comparison <= 0) || (!ascending && comparison >= 0)) {
                pokemonList.set(k, leftList.get(i));
                i++;
            } else {
                pokemonList.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        while (i < leftLenght) {
            pokemonList.set(k, leftList.get(i));
            i++;
            k++;
        }

        while (j < rightLenght
        ) {
            pokemonList.set(k, rightList.get(j));
            j++;
            k++;
        }
    }

    public void mergeSortByLengthOfNameInit(boolean ascending) {
        mergeSortByLengthOfName(pokemonList, 0, pokemonList.size() - 1, ascending);
    }

    /*O Big-Ω (Omega) do algoritmo de ordenação Merge Sort é uma notação usada para descrever o limite inferior de
     desempenho do algoritmo em seu pior caso.Em outras palavras, representa o mínimo de tempo de execução possível
      para o algoritmo, independentemente de como os dados de entrada estejam organizados. O Merge Sort é conhecido
       por ser um algoritmo eficiente em todos os casos, incluindo o pior caso.

    Para o Merge Sort:

    O Big-Ω é Ω(n log n), onde "n" é o número de elementos no arranjo a ser ordenado.
    Isso significa que, no pior caso, o Merge Sort é tão eficiente quanto os algoritmos de ordenação baseados em com-
    parações mais eficientes, como o Quick Sort e o Heap Sort. Independentemente da disposição dos elementos no arran-
    jo de entrada, o Merge Sort garantirá um desempenho mínimo de Ω(n log n) em termos de complexidade de tempo.

    Portanto, o Merge Sort é considerado um algoritmo "estável" em termos de desempenho, e seu desempenho no pior ca
    so é muito previsível e eficiente, tornando-o uma escolha sólida para ordenação de grandes conjuntos de dados.*/

    // Método de ordenação Merge Sort por tamanho do nome
    private void mergeSortByLengthOfName(List<Pokemon> pokemonList, int left, int right, boolean ascending) {
        if (left < right) {
            int meio = (left + right) / 2;
            mergeSortByLengthOfName(pokemonList, left, meio, ascending); // Ordena a metade a esquerda
            mergeSortByLengthOfName(pokemonList, meio + 1, right, ascending); // Ordena a metade a direita
            mergeByLengthOfName(pokemonList, left, meio, right, ascending); // Combina as duas metades
        }
    }

    // Método de combinação de duas metades ordenadas por tamanho do nome
    private void mergeByLengthOfName(List<Pokemon> pokemonList, int left, int meio, int right, boolean ascending) {
        int leftLenght = meio - left + 1;
        int rightLenght = right - meio;

        List<Pokemon> leftList = new ArrayList<>();
        List<Pokemon> rightList = new ArrayList<>();

        for (int i = 0; i < leftLenght; i++) {
            leftList.add(pokemonList.get(left + i));
        }

        for (int j = 0; j < rightLenght
                ; j++) {
            rightList.add(pokemonList.get(meio + 1 + j));
        }

        int i = 0, j = 0, k = left;

        while (i < leftLenght && j < rightLenght) {
            int comparison = compareByLength(leftList.get(i), rightList.get(j));
            if ((ascending && comparison <= 0) || (!ascending && comparison >= 0)) {
                pokemonList.set(k, leftList.get(i));
                i++;
            } else {
                pokemonList.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        while (i < leftLenght) {
            pokemonList.set(k, leftList.get(i));
            i++;
            k++;
        }

        while (j < rightLenght
        ) {
            pokemonList.set(k, rightList.get(j));
            j++;
            k++;
        }
    }

    private int compareByName(Pokemon pokemon1, Pokemon pokemon2) {
        return pokemon1.getName().compareTo(pokemon2.getName());
    }

    private int compareByLength(Pokemon pokemon1, Pokemon pokemon2) {
        int len1 = pokemon1.getName().length();
        int len2 = pokemon2.getName().length();
        return len1 - len2;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }
}
