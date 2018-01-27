package entity;

public class Categoria {
	private int id_categoria;
	private String descripcion;
	
	private static int ADMINISTRADOR = 1;
	private static int ENCARGADO = 2;
	private static int USUARIO = 3;

	
	public int getId_categoria() {
		return id_categoria;
	}
	
	public Boolean esAdministrador () {
		return this.id_categoria == this.ADMINISTRADOR;
	}
	
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setNombreCat(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Categoria(){};
	
	@Override
	public String toString(){
		return Integer.toString(this.getId_categoria())+"- "+this.getDescripcion();
	}
	
	@Override
	public boolean equals(Object o){
		return (o instanceof Categoria && ((Categoria)o).getId_categoria()==this.getId_categoria());
	}
	
	@Override
	public int hashCode(){
		return ((Integer)this.getId_categoria()).hashCode();
	}

}
