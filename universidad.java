public class Universidad {

	private String Nombre;
	private String Nombre_rector;
	private String Nombre_ciudad;
	public void Gestion_Facultad() {

	}
	public void Actualizar_datos() {
	}

    public class Facultad {
        
        private String Nombre_facultad;
        private int Codigo;
        private String Nombre_Decano;
        public void Registrar_Carrera() {
    
        }
    }

    public class Persona {

        private double Cedula;
        private Date Fecha_nacimiento;
        private String Nombre_persona;
        private String Genero;
    
    }
    
    public class Docente {

        private String Profesion;
        private String Nacionalidad;
        private double Sueldo;
        private String Correo;
        public void Gestionar_curso() {
    
        }
        public void Calificar_estudiante() {
    
        }
        public void Calcular_salario() {
    
        }
    }

    public class Estudiantes {

        private Date Ingreso_universidad;
        private String Colegio_graduado;
        private double Promedio;
        public void Inscribirse_curso() {
    
        }
        public void Total_creditos() {
        }
        public void Consultar_estado() {
        }
    }

    public class Carrera {

        private String Nombre_carrera;
        private int Creditos_totales;
        private Tipo_nivel Nivel_carrera;
        private int Duracion;
        public void Seleccione_nivel() {
    
        }
    }

    public class Curso {

        private int Codigo_curso;
        private String Nombre_curso;
        private int Num_creditos;
        private String Num_salon;
        private double Horario;
        public void Seleccionar_Grupo() {
    
        }
        public void Seleccione_Salon() {
        }
        public void Seleccione_Creditos() {
        }
        public void Cupos() {
        }
        public void Cancelar_curso() {
        }
        public void Asignar_profesor() {
        }
        public void Actualizar_horario() {
        }
    }
    public enum Tipo_nivel  {

        + Pregrado :Tipo_nivel,
        + Posgrado :Tipo_nivel;
    
    }
    
}
