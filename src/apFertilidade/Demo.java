package apFertilidade;
import controller.APFController;
import model.Parceiro;
import view.APFView;

public class Demo {
	   public static void main(String[] args) {

	      //fetch student record based on his roll no from the database
	      Parceiro model  = null;

	      //Create a view : to write student details on console
	      APFView view = new APFView();

//	       APFParceirosView windowView;
//	      
//			EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//						windowView = new APFParceirosView();
//						windowView.frame.setVisible(true);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			});

			APFController controller = new APFController(model, view);
			
			controller.getMenu();
//	      controller.printAllParceiros();
	      
//	      //fetch student from record
//	      model= controller.getParceiroById(1);
//	      
//	      //sets current student in the controller
//	      controller.setParceiro(model);
//
//	      //update model data
//	      controller.setParceiroName("Antonio");
//	      
//	      controller.updateParceiroName(model);
//
//	      controller.printAllParceiros();
	      
	      controller.closeConnection();
	      
	      
	   }
	}
