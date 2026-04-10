package org.example.service;

import java.util.ArrayList;
import org.example.model.Medicos;

public class MedicoService {

    private ArrayList<Medicos> medicos = new ArrayList<>();
    private int contadorId = 1;

    public void cadastrar(String nome, String especialidade) {

        Medicos m = new Medicos(contadorId, nome, especialidade);

        medicos.add(m);

        contadorId++;

        System.out.println("Médico cadastrado com sucesso!");

    }

    public void listar() {

        for (Medicos m : medicos) {

            System.out.println("ID: " + m.id + " | Nome: " + m.nome);

        }

    }

    public Medicos buscar(int id) {

        for (Medicos m : medicos) {

            if (m.id == id) {

                return m;

            }

        }

        return null;

    }

}
