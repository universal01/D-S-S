package com.iudigital.funcionariocrud.Controller;

import com.iudigital.funcionariocrud.data.FuncionarioDao;
import com.iudigital.funcionariocrud.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {
    private final FuncionarioDao funcionarioDao;
    
    public FuncionarioController(){
        funcionarioDao = new FuncionarioDao();
    }
    
    public List<Funcionario> getFuncionarios() throws SQLException{
        return funcionarioDao.getAllfuncionarios();
    }
    
    public void createOneFuncionario(Funcionario funcionario) throws SQLException{
        funcionarioDao.createFuncionario(funcionario);
    }
    
    public Funcionario getFuncionario(int idFuncionario)throws SQLException{
        return funcionarioDao.getoneFuncionario(idFuncionario);
        
        
    }
    
    public void update(Funcionario funcionario, int idFuncionario)throws SQLException{
        funcionarioDao.updateFuncionario(funcionario, idFuncionario);
    }
    
    public void delete(int idFuncionario)throws SQLException{
        funcionarioDao.deleteFuncionario(idFuncionario);
        
    }
}
