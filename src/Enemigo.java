public class Enemigo {
    
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;

    public Enemigo() {
    }
    
    
    
    public Enemigo(String nombre,int vida,int ataque,int defensa){
        this.nombre=nombre;
        this.vida=vida;
        this.ataque=ataque;
        this.defensa=defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
    
    public String mostrarDatos(){
        String a;
        a="Enemigo:\n"+"Nombre: "+this.nombre+"\n"+"Vida: "+this.vida+"\n"+"Ataque: "+this.ataque+"\n"+"Defensa: "+this.defensa;
        return a;
    }
    
    
    
}
