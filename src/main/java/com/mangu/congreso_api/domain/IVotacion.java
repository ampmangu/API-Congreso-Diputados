package com.mangu.congreso_api.domain;

import java.time.LocalDate;

public interface IVotacion {

  Long id();

  String legislatura();

  LocalDate fecha();

  String titulo();

  String textoexpediente();
}
