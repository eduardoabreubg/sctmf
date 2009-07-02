package br.uem.din.yandre.sctmf.model.pojo;

public class SimboloString {
    String nome = null;
    
    public SimboloString (String nome) {
        this.nome =  nome;
    }
    
    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SimboloString other = (SimboloString) obj;
        if (this.nome != other.nome && (this.nome == null || !this.nome.equals(other.nome))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        return hash;
    }
    
    public String toString() {
        return nome;
    }
}
