package org.example.service;

import java.util.ArrayList;

import org.example.model.*;
import org.example.enums.*;

public class SolicitacoesService {

    private ArrayList<Solicitacoes> lista = new ArrayList<>();
    private int contadorProtocolo = 1;

    public void criarSolicitacao(Paciente paciente, Medicos medico,
                                 Categoria categoria, int nota, String comentario) {

        Solicitacoes s = new Solicitacoes(contadorProtocolo, paciente, medico, categoria, nota, comentario);

        lista.add(s);

        contadorProtocolo++;

        System.out.println("Solicitação criada com protocolo: " + s.protocolo);

    }

    public void listar() {

        for (Solicitacoes s : lista) {

            System.out.println("Protocolo: " + s.protocolo +
                    " | Paciente: " + s.paciente.nome +
                    " | Médico: " + s.medico.nome +
                    " | Status: " + s.status);

        }

    }

    public Solicitacoes buscar(int protocolo) {

        for (Solicitacoes s : lista) {

            if (s.protocolo == protocolo) {

                return s;

            }

        }

        return null;

    }

    public void atualizarStatus(int protocolo, AcompanhamentoDeStatus novoStatus) {

        Solicitacoes s = buscar(protocolo);

        if (s != null) {

            s.status = novoStatus;

            System.out.println("Status atualizado!");

        } else {

            System.out.println("Solicitação não encontrada.");

        }

    }

    public void painelPorCategoria(Categoria categoria) {

        for (Solicitacoes s : lista) {

            if (s.categoria == categoria) {

                System.out.println("Protocolo: " + s.protocolo);
                System.out.println("Paciente: " + s.paciente.nome);
                System.out.println("Médico: " + s.medico.nome);
                System.out.println("Nota: " + s.nota);
                System.out.println("Comentário: " + s.comentario);
                System.out.println("Status: " + s.status);
                System.out.println("-----------------------------");

            }

        }

    }

}