package orb.bedu.java.backend.sesion2;

import java.util.LinkedList;
import java.util.List;

public class Database {
    private List <Product> db;

    public Database() {
        db = new LinkedList<>();
    }

    public void insert(Product product){
        db.add(product);
    }
    public int size(){
        return db.size();
    }
    public Product getById(Long id){
        for(Product product:db){
            if(product.getId()==id){
                return product;
            }
        }
        return null;
    }
    public void clear(){
        db.clear();
    }
    public void updateProductName(Long productId, String newName) {
        for (Product product : db) {
            if (product.getId() == productId) {
                product.setName(newName);
                break;
            }
        }
    }
    public void removeProduct(Long productId) {
        for (Product product : db) {
            if (product.getId() == productId) {
                db.remove(product);
                break;
            }
        }
    }

}
