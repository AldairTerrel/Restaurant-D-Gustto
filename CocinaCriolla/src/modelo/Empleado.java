/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author USER
 */
public class Empleado {
  private int id;
    private String nombre;
    private String apellido;
    private int horasTrabajadas;
    private String asistencia;
    private String turno;

    // Constructor
    public Empleado(int id, String nombre, String apellido, int horasTrabajadas, String asistencia, String turno) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.horasTrabajadas = horasTrabajadas;
        this.asistencia = asistencia;
        this.turno = turno;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public int getHorasTrabajadas() { return horasTrabajadas; }
    public void setHorasTrabajadas(int horasTrabajadas) { this.horasTrabajadas = horasTrabajadas; }

    public String getAsistencia() { return asistencia; }
    public void setAsistencia(String asistencia) { this.asistencia = asistencia; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }
}