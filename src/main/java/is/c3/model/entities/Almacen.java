package is.c3.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Logger;

import is.c3.model.GestionProductos;
import is.c3.model.Producto;

/**
 * Clase para gestionar las películas de un cine
 */
public class Almacen implements GestionProductos<Producto> {
	private static Logger log = Logger.getLogger(Almacen.class.getName());

	private List<Producto> productos;

	public Almacen() {
		productos = new ArrayList<Producto>();
	}

	public List<Producto> getProductos() {
		return productos;
	}
	
	@Override
	public Boolean find(Producto producto){
		return productos.contains(producto);
	}
	
	@Override
	public List<Producto> findAll(){
		return new ArrayList<>(productos);
	}

	@Override
	public void save(Producto producto) {
	    if (producto != null) {          
	    	productos.add(producto);     
	        log.fine("Producto almacenado: " + producto.getDescripcion());
	    }
	}

	@Override
	public void delete(Producto producto) {
		log.fine("Se va a eliminar el producto: " + producto.getDescripcion());	
	
	}
	
	@Override
	public void deleteAll() {
		log.fine("Se van a eliminar todos los productos");	

	}
	
	@Override
	public void saveAll(Producto[] t) {
	    if (t != null) {
	        for (int i = 0; i < t.length; i++) { //AQUI FALLA ALGO
	            Producto p = t[i];
	            if (p != null) {
	            	productos.add(p);
	                log.fine("Producto añadido: " + p.getDescripcion());
	            }
	        }
	    }
	}
}	
