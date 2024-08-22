package kaif.shoppingmall;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderDetailsController {
    
    @Autowired
    private OrderDetailsService service;
    
    @GetMapping("/orderdetails/")
    //Retrieval
    public List<OrderDetails> list(){
        return service.listAll();
        
    }

    //Retrieve by Id
    @GetMapping("/orderdetails/{id}")
    public ResponseEntity<OrderDetails> get(@PathVariable Integer id){
        try {
        OrderDetails orderDetails = service.get(id);
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    } catch (NoSuchElementException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // 404 Not Found
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  // 500 Internal Server Error
    }

    }


    //create operation
    @PostMapping("/orderDetails")
    public void add(@RequestBody OrderDetails orderDetails){
        service.save(orderDetails);

    }

    //update operation
    @PutMapping("/orderDetails/{id}")
    public ResponseEntity<?> update(@RequestBody OrderDetails orderDetails,@PathVariable Integer id){
        try {
            // Attempt to retrieve the existing OrderDetails by ID
            OrderDetails existOrderDetails = service.get(id);
            
            // Save the updated OrderDetails
            service.save(orderDetails);
            
            // Return HTTP 200 OK if everything is successful
            return new ResponseEntity<>(HttpStatus.OK);
            
        } catch (NoSuchElementException e) {
            // Handle case where the OrderDetails with the given ID does not exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // 404 Not Found
            
        } catch (Exception e) {
            // Handle any other exceptions that might occur
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);  // 500 Internal Server Error
        }

    }

    //delete operation
    @DeleteMapping("/orderDetails/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
