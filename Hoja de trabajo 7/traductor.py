#Fin en mente: Aplicar los conocimientos sobre árboles binarios para implementar un diccionario
#Nombre del programa: traductor.py
#Nombre del programador: Allyson Dulce Abigail Escobar Sandoval
#Descripcion: implementar un diccionario a partir de un árbol binario de búsqueda con las palabras clave que están en diccionario.txt
#Lenguaje: python 3
#Recursos: python 3.11
#Ajuestes pendiente: ninguno
#Fecha de modificacion: ninguna
#Fecha de creacion: 20/3/2026
import re

#creo la asociacion entre la palabra en ingles que sería la llave y la palabra en español, que sería la clave
class Association:
    #inicializar la llave (sin importar si está en mayuscula o miniscula) y el valor
    def __init__(self, key, value):
        self.key = key.lower()
        self.value = value

    #Esto define que la llave es menor (less than)
    def __lt__(self, other):
        return self.key < other.key

    #esta evalúa si la llave es mayor (greater than)
    def __gt__(self, other):
        return self.key > other.key
    #define igualdad entre las claves
    def __eq__(self, other):
        return self.key == other.key

    #esta parte solo imprime la asociación
    def __str__(self):
        return f"({self.key}, {self.value})"


class Node:
    #se crean los nodos
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


class BinaryTree:
    #crear arbol vacio
    def __init__(self):
        self.root = None
    # creamos la raiz de nuestro arbol con la primera palabra del diccionario
    def insert(self, value):
        if self.root is None:
            self.root = Node(value)
        #y como vamos a ir avanzando queremos ir modificando la raiz para hacer subarboles de manera recursiva
        else:
            self._insert(self.root, value)

    #aqui se hace el recorrido recursivo
    def _insert(self, current, value):
        #si la clave es menor va a la izquierda y si es mayor a la derecha
        #y si no hay hijos se inserta ahí el nodo-valor
        if value < current.value:
            if current.left is None:
                current.left = Node(value)
            else:
                self._insert(current.left, value)
        else:
            if current.right is None:
                current.right = Node(value)
            else:
                self._insert(current.right, value)

    def search(self, key):
        #convierte la palabra a minnúscula y empieza desde la raíz
        return self._search(self.root, key.lower())

    #bpusqueda recursiva
    def _search(self, current, key):
        #si no existe no está en el diccionario
        if current is None:
            return None
    #si lo encuentra devuelve la traducción
        if key == current.value.key:
            return current.value.value
        #si es menor busca a la izquierda
        elif key < current.value.key:
            return self._search(current.left, key)
        #y si es mayor busca a la derecha
        else:
            return self._search(current.right, key)

    #solo inicializa los elementos necesarios para empezar 
    def inorder(self):
        #aqui se guardará el resultado
        result = []
        #llama a la función recursiva
        self._inorder(self.root, result)
        #devuelve la lista ordenada
        return result

    #aqui ya se recorre en inorder
    def _inorder(self, current, result):
        #si existe el nodo
        if current is not None:
            #visita izquierda
            self._inorder(current.left, result)
            #actual
            result.append(current.value)
            #derecha
            self._inorder(current.right, result)

#aqui cargo el diccionario
def load_dictionary(filename, tree):
    #el filename básicamente se lo doy en el main que es diccionario.txt (en caso de que se cambie solo será en el main)
    with open(filename, "r", encoding="utf-8") as file:
        #recorro linea por linea
        for line in file:
            #elimino espacios y saltos de linea
            line = line.strip()
            #aqui solo evalua que mi linea empiece y termine con parentesis(word,palabra)
            if line.startswith("(") and line.endswith(")"):
                #recorro mi linea sin contar el parentesis inicial ni final
                line = line[1:-1]
                #aqui recibo dos palabras: ingles y español
                eng, esp = line.split(",")
                #inserta las palabras en el arbol
                tree.insert(Association(eng.strip(), esp.strip()))


def translate_text(filename, tree):
    #hago casi que lo mismo que hice en el diccionario
    with open(filename, "r", encoding="utf-8") as file:
        text = file.read()
    #aqui extraigo solo palabras (no signos) - esto se hace con regex (loa prendi en el colegio)
    words = re.findall(r"[a-zA-Z']+|[^a-zA-Z\s]", text)
    #aqui voy a guardar los resultados
    traduccion = []
    for word in words:
        if re.match(r"[a-zA-Z']+", word):
            #busco la palabra en el arbol
            result = tree.search(word)
            if result:
                #agrego la traduccion
                traduccion.append(result)
            else:
                #si no lo encuentra pongo la palabra en ingles
                traduccion.append(f"*{word}*")
        else:
            traduccion.append(word)
    #une todo en un string con espacios
    return " ".join(traduccion)


#creo mi arbol
tree = BinaryTree()
#cargo el diccionario
load_dictionary("diccionario.txt", tree)

print("Diccionario ordenado:")
#imprimo el diccionario en el inorder
for assoc in tree.inorder():
    print(assoc)

print("\nTraducción:\n")
#traduzco el texto del txt y busco en mi arbol
translation = translate_text("texto.txt", tree)
#imprimo la traduccion
print(translation)
