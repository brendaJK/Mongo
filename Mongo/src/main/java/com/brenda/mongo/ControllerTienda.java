package com.brenda.mongo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerTienda {

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnMostrar;

    @FXML
    private TextField txtExistencias;

    @FXML
    private TextField txtIdProducto;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtTamanio;
    @FXML
    private Label lblResultado;


    ConexionNube conexionNube = new ConexionNube();
    public void guardar(){
        Tienda tienda = new Tienda();
        tienda.setIdRefresco(Integer.parseInt(txtIdProducto.getText()));
        tienda.setNombre(txtNombre.getText());
        tienda.setExistencias(Integer.parseInt(txtExistencias.getText()));
        tienda.setTamanio(txtTamanio.getText());
        tienda.setPrecio(Double.parseDouble(txtPrecio.getText()));

        if (conexionNube.insertar(tienda)==true){
            lblResultado.setText("Se guardaron los datos.");
            clean();
        }else{
            lblResultado.setText("Error al guardar los datos");
        }
    }

    public void actualizar(){
        Tienda productoAnterior = new Tienda();
        Tienda productoNuevo = new Tienda();
        if (txtIdProducto!=null) {
            productoAnterior.setIdRefresco(Integer.parseInt(txtIdProducto.getText()));
            productoNuevo.setIdRefresco(Integer.parseInt(txtIdProducto.getText()));
            productoNuevo.setNombre(txtNombre.getText());
            productoNuevo.setExistencias(Integer.parseInt(txtExistencias.getText()));
            productoNuevo.setTamanio(txtTamanio.getText());
            productoNuevo.setPrecio(Double.parseDouble(txtPrecio.getText()));;

            if(conexionNube.actualizar(productoAnterior,productoNuevo)==true){
                lblResultado.setText("Se actualizaron con exito");
                clean();
            } else{
                lblResultado.setText("Error al actualizar los datos");
            }
        } else{
            txtIdProducto.setText("Asigna un valor al id");
        }
    }

    public void eliminar(){
        if(txtIdProducto!=null) {
            int idProducto = Integer.parseInt(txtIdProducto.getText());
            if (conexionNube.eliminar(idProducto) == true) {
                lblResultado.setText("Registro eliminado");
                clean();
            } else {
                lblResultado.setText("Error al eliminar");
            }
        } else{
            txtIdProducto.setText("Valor nulo");
        }
    }

    public void mostrar(){
        if(conexionNube.mostrar()==true){
            lblResultado.setText("Mostrar datos");
            clean();
        } else{
            lblResultado.setText("Error al mostrar los datos");
            clean();
        }
    }

    public void clean(){
        txtIdProducto.setText("");
        txtPrecio.setText("");
        txtNombre.setText("");
        txtTamanio.setText("");
        txtExistencias.setText("");

    }
}
