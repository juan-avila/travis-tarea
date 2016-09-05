/*lista doblemente enlazada
DESAFIO HACERLO para las circulares: simple y doble
*/
class CNodo
{
	int dato;
	CNodo siguiente;
	CNodo anterior;

	public CNodo()
	{
		anterior = null;
                siguiente = null;
	}
}

class CLista
{
	CNodo cabeza;
        CNodo actual;
	public CLista()
	{
		cabeza = null;
                actual = null;
	}

	public void InsertarDato(int dat)
	{
		CNodo NuevoNodo;
                CNodo ant=null,sig=null;
		NuevoNodo = new CNodo();
		NuevoNodo.dato=dat;
                int ban=0;
		if (cabeza == null)
                {   NuevoNodo.siguiente=null;
                    NuevoNodo.anterior=null;
                    cabeza = NuevoNodo;
                    actual= NuevoNodo;
                }
                else { if (dat<cabeza.dato)
                        {   NuevoNodo.siguiente=cabeza;
                            NuevoNodo.anterior=null;
                            cabeza.anterior=NuevoNodo;
                            cabeza = NuevoNodo;
                            actual=NuevoNodo;
                        }
                    else {  ant=actual;
                            sig=actual;
                            while (ban==0)
                            {   if (dat>=sig.dato) {
                                    ant=sig;
                                    sig=sig.siguiente;
                                }
                                else { if (dat<sig.dato) {
                                            sig=ant;
                                            ant=ant.anterior;
                                        }
                                    }
                                if ((ant==null)||(sig==null)) {ban=1;}
                                else {
                                        if ((dat<sig.dato)&&(ant.dato<dat))
                                        {ban=1;}
                                    }
                            }
                            if (ant!=null) ant.siguiente=NuevoNodo;
                            NuevoNodo.anterior=ant;
                            NuevoNodo.siguiente=sig;
                            actual=NuevoNodo;
                            if (sig!=null) sig.anterior=NuevoNodo;
                        }
                }
	}

	public void EliminarDato(int dat)
	{  CNodo ant=null,sig=null;
           int ban=0;
	   if (Vacia()) {System.out.print("Lista vacía ");}
           else
             {
                 if (dat<cabeza.dato)  System.out.print("dato no existe en la lista ");
                 
                 if(cabeza.dato==dat){
                 if(cabeza.siguiente==null){
                         cabeza=null;
                         actual=null;
                     }
                 }
                    else if (dat==cabeza.dato)
                        {   cabeza=cabeza.siguiente;
                            cabeza.anterior=null;
                            actual=cabeza;
                        }
                    
                    if(dat==sig.dato){
                        ant=sig;
                        sig=sig.siguiente;
                        else{
                                if(dat==sig.dato)
                                    ant.siguiente=sig.siguiente;
                                }
                            }
                    }
                    
                    else {  ant=actual;
                            sig=actual;
                            while (ban==0)
                            { if ((ant.dato<dat)&&(dat<sig.dato))  { ban=1;}
                              else{
                                if (dat>sig.dato) {
                                    ant=sig;
                                    sig=sig.siguiente;}
                                   else if (dat<sig.dato) {
                                             sig=ant;
                                             ant=ant.anterior;
                                           }
                                if ((sig==null)||(ant==null)) {ban=1;}
                                else if ((sig.dato==dat)||(ant.dato==dat)) ban=1;
                              }
                            }
                            if ((sig==null)||(ant==null)) System.out.print("dato no existe en la Lista ");
                            else if (dat==sig.dato)
                                  { ant=sig.anterior;
                                    ant.siguiente=sig.siguiente;
                                    if (sig.siguiente!=null) {
                                        sig=sig.siguiente;
                                        sig.anterior=ant;
                                        actual=sig;
                                    }
                                    else actual=ant;
                                  }
                                else if (dat==ant.dato) {
                                     ant=ant.anterior;
                                     ant.siguiente=sig;
                                     sig.anterior=ant;
                                     actual=sig;
                                      }
                                     else System.out.print("dato no existe en la Lista ");
                        }
                }

	}

        public boolean Vacia()
        {    return(cabeza==null);
        }

	public void VisualizarDatos()
	{
		CNodo Nodo;
                Nodo=cabeza;
                if (!Vacia()) {
                while (Nodo!=null)
                {	System.out.print(" " + Nodo.dato +" ");
                        Nodo = Nodo.siguiente;
                }
                }
                else System.out.print("Lista vacía");
	}

}

public class Lista2en
{
	public static void main(String args[])
	{
		CLista objLista= new CLista();
		System.out.println("Lista Original:");
		objLista.InsertarDato(3);
		objLista.InsertarDato(1);
                objLista.InsertarDato(3);
                objLista.InsertarDato(7);
                objLista.InsertarDato(20);
                objLista.InsertarDato(30);
		objLista.VisualizarDatos();
		System.out.println("\nAntes del 5: ");
		objLista.InsertarDato(5);
                /*objLista.EliminarDato(3);
                objLista.EliminarDato(20);
                objLista.EliminarDato(7);*/
                //objLista.EliminarDato(7);

		objLista.VisualizarDatos();
	}
}
