package br.edu.ifrn.tarefa.mapper;

import br.edu.ifrn.tarefa.dto.TarefaRequestDto;
import br.edu.ifrn.tarefa.dto.TarefaResponseDto;
import br.edu.ifrn.tarefa.model.Tarefa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TarefaMapper {

    public Tarefa toEntity(TarefaRequestDto dto) {
        if (dto == null) {
            return null;
        }

        return Tarefa.builder().titulo(dto.titulo())
                .descricao(dto.descricao())
                .prioridade(dto.prioridade())
                .build();
    }

    public TarefaResponseDto toDTO(Tarefa entity) {
        if (entity == null) {
            return null;
        }

        return TarefaResponseDto.builder().titulo(entity.getTitulo())
                .concluida(entity.isConcluida())
                .prioridade(entity.getPrioridade())
                .build();

}