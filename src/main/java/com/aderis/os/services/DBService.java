package com.aderis.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aderis.os.domain.Cliente;
import com.aderis.os.domain.OS;
import com.aderis.os.domain.Tecnico;
import com.aderis.os.domain.enuns.Prioridade;
import com.aderis.os.domain.enuns.Status;
import com.aderis.os.repositories.ClienteRepository;
import com.aderis.os.repositories.OSRepository;
import com.aderis.os.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private OSRepository osRepository;

	public void instanciaDB() {
		Tecnico t1 = new Tecnico(null, "Aderis Martins", "116.443.480-20", "(88) 98888-8888");
		Tecnico t2 = new Tecnico(null, "Linux Torvalds", "662.989.040-00", "(88) 96666-6666");
		Cliente c1 = new Cliente(null, "Jaqueline Cavaco", "857.250.050-20", "(88) 97777-7777");

		OS os1 = new OS(null, Prioridade.ALTA, "Teste", Status.ANDAMENTO, t1, c1);

		tecnicoRepository.saveAll(Arrays.asList(t1,t2));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}
}
