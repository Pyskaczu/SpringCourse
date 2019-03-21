import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.demo.model.FoodGroup;
import com.demo.model.FoodGroupDAO;

public class MyApp {

	public static void main(String[] args) {
		ApplicationContext appContext = new FileSystemXmlApplicationContext("appContext.xml");
		FoodGroupDAO fgDAO = appContext.getBean("foodGroupDAO", FoodGroupDAO.class);
		FoodGroup fg;

		try {
			System.out.println("**************** Querying all records **********************************************");
			for (FoodGroup fgIter : fgDAO.getAllFoodGroups()) {
				printFruiteGroup(fgIter);
			}

			System.out.println("**************** Querying first record *********************************************");
			for (FoodGroup fgIter : fgDAO.getJustFriutsFoodGroups()) {
				printFruiteGroup(fgIter);
			}

			System.out.println("**************** Querying selected records ******************************************");
			printFruiteGroup(fgDAO.getFoodGroup(3));
			printFruiteGroup(fgDAO.getFoodGroup(1));

			System.out.println("**************** Adding some records ************************************************");
			fgDAO.addDefinedFoodGroup("NotRealFoodGroup", "Some test group");

			for (FoodGroup fgIter : fgDAO.getAllFoodGroups()) {
				printFruiteGroup(fgIter);
			}

			fg = new FoodGroup();
			fg.setName("Random name");
			fg.setDescription("Random description");

			fgDAO.addBeanFoodGroup(fg);

			for (FoodGroup fgIter : fgDAO.getAllFoodGroups()) {
				printFruiteGroup(fgIter);
				fg = fgIter;
			}

			System.out
					.println("**************** Updating the last record ********************************************");
			fg.setName(fg.getName() + "_name modified");
			fg.setDescription(fg.getDescription() + "_description modified");
			fgDAO.updateBeanFoodGroup(fg);

			for (FoodGroup fgIter : fgDAO.getAllFoodGroups()) {
				printFruiteGroup(fgIter);
				fg = fgIter;
			}

			System.out
					.println("**************** Deleting the record before the last record **************************");
			fgDAO.deleteDescriptionFoodGroup(fg.getId() - 1);
			for (FoodGroup fgIter : fgDAO.getAllFoodGroups()) {
				printFruiteGroup(fgIter);
				fg = fgIter;
			}

			System.out
					.println("**************** Updating transactional batch records ********************************");
			List<FoodGroup> foodGroups = new ArrayList<FoodGroup>();

			String[][] data = { { "GroupA", "Description A" }, { "GroupB", "Description B" },
					{ "GroupC", "Description C" }, { "GroupD", "Description D" }, { "GroupAb", "Description Ab" }, };

			for (String[] row : data) {
				foodGroups.add(new FoodGroup(row[0], row[1]));
			}

			int[] numberOfRowsAffectedArray = fgDAO.addFoodGroups(foodGroups);
			for (int i : numberOfRowsAffectedArray) {
				System.out.println("Batch update affected rows: " + i);
			}

			for (FoodGroup fgIter : fgDAO.getAllFoodGroups()) {
				printFruiteGroup(fgIter);
				fg = fgIter;
			}

			System.out.println("**************** Adding record using SI ********************************************");
			System.out.println(
					"SI added group id: " + fgDAO.add_SI_BeanFoodGroup(new FoodGroup("GroupSI", "Added using SI")));

			System.out.println("**************** Querying first record by procedure call ***************************");
			for (FoodGroup fgIter : fgDAO.getJustFriutsFoodGroups()) {
				printFruiteGroup(fgIter);
			}

			System.out.println("**************** Querying for object demo ******************************************");
			fgDAO.quaryForObjectDemo();

		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
		}

		((FileSystemXmlApplicationContext) appContext).close();
	}

	public static void printFruiteGroup(FoodGroup fg) {
		System.out.println(fg.talkAboutYourself());
	}
}
