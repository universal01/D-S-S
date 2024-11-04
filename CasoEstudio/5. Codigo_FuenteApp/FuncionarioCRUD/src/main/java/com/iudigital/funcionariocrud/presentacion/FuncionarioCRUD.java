package com.iudigital.funcionariocrud.presentacion;

import com.iudigital.funcionariocrud.Controller.FuncionarioController;
import com.iudigital.funcionariocrud.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;



public class FuncionarioCRUD {
    
    public static void getFuncionarioList(FuncionarioController funcionarioController) {
        try {
            List<Funcionario> funcionarios = funcionarioController.getFuncionarios();
            
            if (funcionarios.isEmpty()){
                System.out.println("No hay datos");
            }else{
                funcionarios.forEach(funcionario ->{
                    System.out.println("Id: " + funcionario.getIdFuncionario());
                    System.out.println("Tipo de identificación: " +  funcionario.getTipoIdentificacion());
                    System.out.println("Numero de identificación: " +  funcionario.getNumeroIdentificacion());
                    System.out.println("Nombres: " +  funcionario.getNombres());
                    System.out.println("Apellidos: " +  funcionario.getApellidos());
                    System.out.println("Estado Civil: " +  funcionario.getEstadoCivil());
                    System.out.println("sexo: " +  funcionario.getSexo());
                    System.out.println("Dirección: " +  funcionario.getDireccion());
                    System.out.println("Telefono: " +  funcionario.getTelefono());
                    System.out.println("===================================================== " );
                    System.out.println("===================================================== " );
                    System.out.println("===================================================== " );
                    
                });
            }
        } catch (SQLException ex) {
            
            ex.getStackTrace();

        }
        
    }
    
    public static void crear(FuncionarioController funcionarioController){

        try {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite su tipo de documento: ");
        String TipoIdentificacion = sc.nextLine();
        System.out.println("Su tipo de documento es: " + TipoIdentificacion);
        System.out.println("========================================");
        
        System.out.println("Digite su numero de documento: ");
        String NumeroIdentificacion = sc.nextLine();
        System.out.println("Su numero de documento es: " + NumeroIdentificacion);
        System.out.println("========================================");
        
        System.out.println("Digite sus Nombres: ");
        String Nombres = sc.nextLine();
        System.out.println("Sus Nombres son: " + Nombres);
        System.out.println("========================================");
        
        System.out.println("Digite sus Apellidos: ");
        String Apellidos = sc.nextLine();
        System.out.println("Sus apellidos son: " + Apellidos);
        System.out.println("========================================");
        
        System.out.println("Digite su estado civil: ");
        String EstadoCivil = sc.nextLine();
        System.out.println("Su Estado civil es: " + EstadoCivil);
        System.out.println("========================================");
        
        System.out.println("Digite el sexo con el que se identifica: ");
        String Sexo = sc.nextLine();
        System.out.println("Su sexo es: " + Sexo);
        System.out.println("========================================");
        
        System.out.println("Digite su Dirección: ");
        String Direccion = sc.nextLine();
        System.out.println("Su Dirección es: " + Direccion);
        System.out.println("========================================");
    
        
        System.out.println("Digite su numero de telfono: ");
        String Telefono = sc.nextLine();
        System.out.println("Su numero de telfono es: " + Telefono);
        System.out.println("========================================");
        
        Funcionario funcionario = new Funcionario();
        funcionario.setTipoIdentificacion(TipoIdentificacion);
        funcionario.setNumeroIdentificacion(NumeroIdentificacion);
        funcionario.setNombres(Nombres);
        funcionario.setApellidos(Apellidos);
        funcionario.setEstadoCivil(EstadoCivil);
        funcionario.setSexo(Sexo);
        funcionario.setDireccion(Direccion);
        funcionario.setTelefono(Telefono);
        funcionarioController.createOneFuncionario(funcionario);
        getFuncionarioList(funcionarioController);
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        System.out.println("El funcionario ha sido registrado con exito. ");
    }
    
    public static void actualizar(FuncionarioController funcionarioController) {
    try {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el ID del funcionario a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consumir la nueva línea

        Funcionario funcionario = funcionarioController.getFuncionario(id);
        if (funcionario == null) {
            System.out.println("Funcionario no encontrado.");
            return;
        }

        System.out.println("Actualizando datos para: " + funcionario.getNombres() + " " + funcionario.getApellidos());

        System.out.println("Digite nuevo tipo de documento (actual: " + funcionario.getTipoIdentificacion() + "): ");
        String tipoIdentificacion = sc.nextLine();
        if (!tipoIdentificacion.isEmpty()) {
            funcionario.setTipoIdentificacion(tipoIdentificacion);
        }

        System.out.println("Digite nuevo número de documento (actual: " + funcionario.getNumeroIdentificacion() + "): ");
        String numeroIdentificacion = sc.nextLine();
        if (!numeroIdentificacion.isEmpty()) {
            funcionario.setNumeroIdentificacion(numeroIdentificacion);
        }

        System.out.println("Digite nuevos nombres (actual: " + funcionario.getNombres() + "): ");
        String nombres = sc.nextLine();
        if (!nombres.isEmpty()) {
            funcionario.setNombres(nombres);
        }

        System.out.println("Digite nuevos apellidos (actual: " + funcionario.getApellidos() + "): ");
        String apellidos = sc.nextLine();
        if (!apellidos.isEmpty()) {
            funcionario.setApellidos(apellidos);
        }

        System.out.println("Digite nuevo estado civil (actual: " + funcionario.getEstadoCivil() + "): ");
        String estadoCivil = sc.nextLine();
        if (!estadoCivil.isEmpty()) {
            funcionario.setEstadoCivil(estadoCivil);
        }

        System.out.println("Digite nuevo sexo (actual: " + funcionario.getSexo() + "): ");
        String sexo = sc.nextLine();
        if (!sexo.isEmpty()) {
            funcionario.setSexo(sexo);
        }

        System.out.println("Digite nueva dirección (actual: " + funcionario.getDireccion() + "): ");
        String direccion = sc.nextLine();
        if (!direccion.isEmpty()) {
            funcionario.setDireccion(direccion);
        }

        System.out.println("Digite nuevo número de teléfono (actual: " + funcionario.getTelefono() + "): ");
        String telefono = sc.nextLine();
        if (!telefono.isEmpty()) {
            funcionario.setTelefono(telefono);
        }

        // Realiza la actualización en la base de datos
        funcionarioController.update(funcionario, id);
        getFuncionarioList(funcionarioController);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    System.out.println("Funcionario actualizado con éxito.");
        
}
    public static void eliminar(FuncionarioController funcionarioController) {
    try {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el ID del funcionario a eliminar: ");
        int id = sc.nextInt();
        
        // Confirma la eliminación
        System.out.println("¿Está seguro de que desea eliminar al funcionario con ID " + id + "? (s/n)");
        sc.nextLine(); // Consumir la nueva línea
        String confirmacion = sc.nextLine();
        
        if (confirmacion.equalsIgnoreCase("s")) {
            funcionarioController.delete(id);
            System.out.println("Funcionario eliminado con éxito.");
        } else {
            System.out.println("Eliminación cancelada.");
        }
        
        getFuncionarioList(funcionarioController);
    } catch (SQLException ex) {
    }
}
    
    
    
public static void main(String[] args) {
        FuncionarioController funcionarioController = new FuncionarioController();
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Listar funcionarios");
            System.out.println("2. Crear funcionario");
            System.out.println("3. Actualizar funcionario");
            System.out.println("4. Eliminar funcionario");
            System.out.println("5. Salir");

            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();

            switch (option) {
                case 1 -> getFuncionarioList(funcionarioController);
                case 2 -> crear(funcionarioController);
                case 3 -> actualizar(funcionarioController);
                case 4 -> eliminar(funcionarioController);
                case 5 -> System.exit(0);
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}

