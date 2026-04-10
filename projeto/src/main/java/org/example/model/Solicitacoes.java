package org.example.model;

import org.example.enums.Categoria;
import org.example.enums.AcompanhamentoDeStatus;

public class Solicitacoes {

    public int protocolo;
    public Paciente paciente;
    public Medicos medico;
    public Categoria categoria;
    public int nota;
    public String comentario;
    public AcompanhamentoDeStatus status;

    public Solicitacoes(int protocolo, Paciente paciente, Medicos medico,
                        Categoria categoria, int nota, String comentario) {

        this.protocolo = protocolo;
        this.paciente = paciente;
        this.medico = medico;
        this.categoria = categoria;

        if (nota >= 0 && nota <= 5) {
            this.nota = nota;
        } else {
            throw new IllegalArgumentException("A nota deve ser entre 0 e 5");
        }

        this.comentario = comentario;
        this.status = AcompanhamentoDeStatus.REGISTRADO;

    }

}