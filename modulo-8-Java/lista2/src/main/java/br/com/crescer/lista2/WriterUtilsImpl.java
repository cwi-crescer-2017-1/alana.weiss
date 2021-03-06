/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.lista2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.Writer;

/**
 *
 * @author alana'
 */
public class WriterUtilsImpl implements WriterUtils{

    @Override
    public void write(String file, String conteudo) throws Exception{
       if(!file.contains(".txt"))
            throw new Exception("Arquivo invalido. É necessario que seja um txt.");
        
        final File arquivo = new File(file);
        
        if(arquivo.isDirectory())
            throw new Exception("Arquivo inválido.");
        
        try (
            final Writer writer = new FileWriter(arquivo);
            final BufferedWriter buffer = new BufferedWriter(writer);
        ) {
           
            buffer.append(conteudo);
            buffer.flush();
                
        } catch (FileNotFoundException e) {
            throw new Exception("Arquivo não encontrado.");
        }
    }
    
}
