package com.iudigital.funcionariocrud.data;

import com.iudigital.funcionariocrud.domain.Funcionario;
import com.iudigital.funcionariocrud.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {
    private static final String GET_FUNCIONARIOS = "select * from fincionarios";
    private static final String CREATE_FUNCIONARIO = "insert into funcionarios (tipo_identificacion, numero_identificacion,"
            + "nombres, apellidos,estado_civil, sexo, direccion, telefono, fecha_nacimiento) values (?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_FUNCIONARIO_BY_ID = "select * from funcionarios where funcionarios_id = ?";
    private static final String UPDATE_FUNCIONARIO = "update funcionarios set tipo_identificacion = ?, numero_identificacion = ?,"
            + "nombres = ?, apellidos = ?, estado_civil = ?, sexo = ?, direccion = ?, telefono = ?, fecha_nacimiento = ?";
    private static final String DELETE_FUNCIONARIO = "delete from car where funcionarios_id";
    
    public List<Funcionario> getAllfuncionarios () throws SQLException{
        Connection connection = null;
        PreparedStatement PreparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> funcionarios = new ArrayList<>();
         try{
             
             connection = ConnectionUtil.getConnection();
             PreparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
             resultSet =PreparedStatement.executeQuery();
             while (resultSet.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(resultSet.getInt("funcionarios_id"));
                funcionario.setTipoIdentificacion(resultSet.getString("tipo_identificacion"));
                funcionario.setNumeroIdentificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setEstadoCivil(resultSet.getString("estado_civil"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionarios.add(funcionario);
                 
             }      
             return funcionarios;
         }finally{
             
             if (connection != null){
                 connection.close();
             }
             
             if (PreparedStatement != null) {
                 PreparedStatement.close();
             }
             
             if (resultSet != null) {
                 resultSet.close();
             }
         }
        
    }
    
    public void createFuncionario(Funcionario funcionario)throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedstatement = connection.prepareCall(CREATE_FUNCIONARIO);
            preparedstatement.setString(1, funcionario.getTipoIdentificacion());
            preparedstatement.setString(2, funcionario.getNumeroIdentificacion());
            preparedstatement.setString(3, funcionario.getNombres()); 
            preparedstatement.setString(4, funcionario.getApellidos()); 
            preparedstatement.setString(5, funcionario.getEstadoCivil()); 
            preparedstatement.setString(6, funcionario.getSexo());
            preparedstatement.setString(7, funcionario.getDireccion());
            preparedstatement.setString(8, funcionario.getTelefono());
            preparedstatement.executeUpdate();
            
                    
        }finally{
             if (connection != null){
                 connection.close();
             }
             
             if (preparedstatement != null){
                 preparedstatement.close();
             }
           
            
        }
    }
    public Funcionario getoneFuncionario(int idFuncionario) throws SQLException{
        
        Connection connection = null;
        PreparedStatement PreparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = null;
        
        try{
             connection = ConnectionUtil.getConnection();
             PreparedStatement = connection.prepareStatement(GET_FUNCIONARIO_BY_ID);
             PreparedStatement.setInt(1, idFuncionario);
             resultSet =PreparedStatement.executeQuery();
             if (resultSet.next()){
                 funcionario = new Funcionario();
                 funcionario.setIdFuncionario(resultSet.getInt("funcionarios_id"));
                 funcionario.setTipoIdentificacion(resultSet.getString("tipo_identificacion"));
                 funcionario.setNumeroIdentificacion(resultSet.getString("numero_identificacion"));
                 funcionario.setNombres(resultSet.getString("nombres"));
                 funcionario.setApellidos(resultSet.getString("apellidos"));
                 funcionario.setEstadoCivil(resultSet.getString("estado_civil"));
                 funcionario.setSexo(resultSet.getString("sexo"));
                 funcionario.setDireccion(resultSet.getString("direccion"));
                 funcionario.setTelefono(resultSet.getString("telefono"));
                 
                 
             }
             return funcionario;
            
        }finally{
             if (connection != null){
                 connection.close();
             }
             
             if (PreparedStatement != null) {
                 PreparedStatement.close();
             }
             
             if (resultSet != null) {
                 resultSet.close();
             }
        }
        
    }
    public void updateFuncionario(Funcionario funcionario, int idFuncionario)throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedstatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedstatement = connection.prepareStatement(UPDATE_FUNCIONARIO);
            preparedstatement.setString(1, funcionario.getTipoIdentificacion());
            preparedstatement.setString(2, funcionario.getNumeroIdentificacion());
            preparedstatement.setString(3, funcionario.getNombres()); 
            preparedstatement.setString(4, funcionario.getApellidos()); 
            preparedstatement.setString(5, funcionario.getEstadoCivil()); 
            preparedstatement.setString(6, funcionario.getSexo());
            preparedstatement.setString(7, funcionario.getDireccion());
            preparedstatement.setString(8, funcionario.getTelefono());
            preparedstatement.setInt(9, idFuncionario);
            preparedstatement.executeUpdate();
            
                    
        }finally{
             if (connection != null){
                 connection.close();
             }
             
             if (preparedstatement != null){
                 preparedstatement.close();
             }
           
            
        }
        
    }
    
    public void deleteFuncionario(int idFuncionario)throws SQLException {
              Connection connection = null;
        PreparedStatement preparedstatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedstatement = connection.prepareStatement(DELETE_FUNCIONARIO); 
            preparedstatement.setInt(9, idFuncionario);
            preparedstatement.executeUpdate();
            
                    
        }finally{
             if (connection != null){
                 connection.close();
             }
             
             if (preparedstatement != null){
                 preparedstatement.close();
             }
           
            
        }
        
        
    }
}
    
    
           
