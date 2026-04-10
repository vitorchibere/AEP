package org.example.service;

import java.util.ArrayList;
import org.example.model.Paciente;

public class PacienteService {

    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private int contadorId = 1;

    public void cadastrar(String nome, String cpf) {

        Paciente p = new Paciente(contadorId, nome, cpf);
        pacientes.add(p);

        contadorId++;

        System.out.println("Paciente cadastrado com sucesso!");

    }

    public void listar() {

        for (Paciente p : pacientes) {

            System.out.println("ID: " + p.id + " | Nome: " + p.nome);

        }

    }

    public Paciente buscar(int id) {

        for (Paciente p : pacientes) {

            if (p.id == id) {

                return p;

            }

        }

        return null;

    }

}