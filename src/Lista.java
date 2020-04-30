public class Lista {
    private Nodo cabeza;
    private Nodo cola;
    private int size;

    public Lista() {
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public Nodo getCola() {
        return cola;
    }

    public void setCola(Nodo cola) {
        this.cola = cola;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    
    public void pushFront(Enemigo enemigo){
        Nodo nodo=new Nodo(enemigo);
        nodo.setNext(this.cabeza);
        this.setCabeza(nodo);
        size++;
        
        if(cola==null){
            this.cola=this.cabeza;
        }
    }
    
   public boolean popFront(){
       if(this.cabeza==null){
           return false;
        }
       this.cabeza=this.cabeza.getNext();
       if(this.cabeza==null){
           this.cola=null;
       }
       size--;
       return true;
   }
   
   public Enemigo topFront(){
       return this.cabeza.getDato();
   }
   
   public void pushBack(Enemigo enemigo){
       Nodo nodo=new Nodo(enemigo);
       nodo.setNext(null);
       
       if(this.cola==null){
           this.cabeza=this.cola=nodo;
       }else{
           this.cola.setNext(nodo);
           this.cola=nodo;
       }
       size++;
   }
   
   public boolean popBack(){
       if(this.cabeza==null){
           return false;
       }
       
       if(this.cabeza==this.cola){
           this.cabeza=this.cola=null;
       }else{
           Nodo temp=new Nodo();
           temp=this.cabeza;
           while(temp.getNext().getNext()!=null){
               temp=temp.getNext();
           }
           temp.setNext(null);
           this.cola=temp;
           
       }
       size--;
       return true;
   }
   
   public Enemigo topBack(){
       return this.cola.getDato();
   }
   
   public void addAfter(Nodo nodo,Enemigo enemigo){
       Nodo nodo2=new Nodo(enemigo);
       nodo2.setNext(nodo.getNext());
       nodo.setNext(nodo2);
       if(this.cola==nodo){
           this.cola=nodo2;
       }
       size++;
   }
   
    public void addBefore(Nodo nodo,Enemigo enemigo){
       Nodo nodo2=new Nodo(enemigo);
       nodo2.setNext(nodo);
       
       Nodo temp=new Nodo();
       temp=this.cabeza;
       while(temp.getNext()!=nodo){
            temp=temp.getNext();
       }
       
       temp.setNext(nodo2);
       
       if(nodo==this.cabeza){
           this.cabeza=nodo2;
       }
       size++;
   }
    
    public Nodo getN(int n){
        Nodo temp=new Nodo();
        temp=this.cabeza;
        for(int i=0;i<n;i++){
            temp=temp.getNext();
        }
        return temp;
    }
    
   public void addAtK(int k,Enemigo e){
       Nodo t=new Nodo();
       t=this.getN(k-1);
       this.addAfter(t,e);
    }
   
   public void removeAtK(int k){
       Nodo t=new Nodo();
       Enemigo e=new Enemigo();
       
       t=this.getN(k);
       e=t.getDato();
       this.eraseKey(e);
   }
    
    public boolean isEmpty(){
        if(this.cabeza==null&&this.cola==null){
            return true;
        }
        return false;
    }
    
    public boolean findKey(Enemigo e){
        Nodo temp=new Nodo();
        temp=this.cabeza;
        while(temp!=null){
            if(e.equals(temp.getDato())==true){
                return true;
            }  
        }
        return false;
    }
    
    public void eraseKey(Enemigo e){
        if(this.findKey(e)==true){
            
            if(this.cabeza.getDato().equals(e)){
                this.cabeza=this.cabeza.getNext();
            }else{
                Nodo temp=new Nodo();
                temp=this.cabeza;
                while((temp.getNext().getDato()).equals(e)==false){
                temp=temp.getNext();
                }
                if(this.cola==temp.getNext()){
                    this.cola=temp;
                }
                temp.setNext(temp.getNext().getNext());
            }
            
            size--;
        }
        
    }
    
    
    
    public Enemigo getEnemigo(int n){
        Nodo temp=new Nodo();
        temp=this.cabeza;
        for(int i=0;i<n;i++){
            temp=temp.getNext();
        }
        return temp.getDato();
    }
    
    public Enemigo getEnemigoXNombre(String nombre){
        Nodo e=new Nodo();
        e=this.cabeza;
        while(e.getNext()!=null){
            if(e.getDato().getNombre()==nombre){
                return e.getDato();            
            }
            e=e.getNext();      
        }
        return null;
    }
    
    public Enemigo getEnemigoXVida(int vida){
        Nodo e=new Nodo();
        e=this.cabeza;
        while(e.getNext()!=null){
            if(e.getDato().getVida()==vida){
                return e.getDato();            
            }
            e=e.getNext();      
        }
        return null;
    }
    
}
