import java.util.Scanner;
import java.util.stream.*;
import java.util.Arrays;

public class PC {
    Detail[] details;
    public static void main(String[] args) {
        int n = 5;
        PC pc = new PC();
        Scanner console = new Scanner(System.in);
        do {
            System.out.println("Выберите действие:\n1. Просмотреть.\n2. Добавить\n3. Удалить.\n4. Отсортировать.");
            System.out.println("5. Выйти");
            System.out.print("Действие: ");
            n = console.nextInt();
            System.out.println("");
            switch (n) {
                case 1:
                    pc.showChoosen(pc.details);
                    break;
                case 2:
                    pc.addCategory(pc.details, console);
                    break;
                case 3:
                    pc.deleteCategory(pc.details, console);
                    break;
                case 4:
                    pc.sortDetails(pc.details);
                    break;
                default:
                    break;
            }
        } while (n != 5);
        console.close();
    }

    PC () {
        details = new Detail[8];
        details[0] = new Detail(new String("Процессор: i5-3770K"), 5000);
        details[1] = new Detail(new String("Материнская плата: Asus Z77-A"), 8000);
        details[2] = new Detail(new String("Видеокарта: GeForce GTX 1060 G1 Gaming 6GB"), 16000);
        details[3] = new Detail(new String("Оперативная память: Crucial Balistix 8 GB"), 6000);
        details[4] = new Detail(new String("Корпус: DEEPCOOLMATREXX 30"), 2800);
        details[5] = new Detail(new String("Блок питания: POWERMAN 450W"), 3000);
        details[6] = new Detail(new String("Охлаждение компьютера: DEEPCOOL GAMMAX 400"), 2500);
        details[7] = new Detail(new String("HDD диск/SSD накопитель: WD BLUE 1TB"), 3500);
    }

    public void showChoosen(Detail[] details) {
        System.out.println("Выбраны следующие категории: ");
        int count = 0;

        int detailsLength = details.length;
        for (int i = 0; i < detailsLength; i++) {
            if (details[i].isChosen) {
                count++;
                System.out.print(count + ". ");
                details[i].showDetail();
            }
        }
        System.out.println("");
    }

    public void addCategory(Detail[] details, Scanner console) {
        int detailsNumber = details.length;
        int catergory = detailsNumber + 1;
        do {
            System.out.println("Выбреите категорию для добавления: ");
            for (int i = 0; i < detailsNumber; i++) {
                System.out.print((i + 1) + ". ");
                details[i].showDetail();
            }
            System.out.println(detailsNumber + 1 + ". Выход.");
            System.out.print("Выбор: ");
            
            catergory = console.nextInt();
            System.out.println("");
            if (catergory > 0 && catergory <= detailsNumber) {
                details[catergory - 1].isChosen = true;
            }
        } while (catergory != detailsNumber + 1);
    }

    public void deleteCategory(Detail[] details, Scanner console) {
        int detailsNumber = details.length;
        int catergory = detailsNumber + 1;
        int count = 0;
        
        do {
            count = 0;
            System.out.println("Выбреите категорию для удаления: ");
            for (int i = 0; i < detailsNumber; i++) {
                if (details[i].isChosen) {
                    count++;
                    System.out.print(count + ". ");
                    details[i].showDetail();
                }
            }
            System.out.println(count + 1 + ". Выход.");
            System.out.print("Выбор: ");

            catergory = console.nextInt();
            System.out.println("");
            if (catergory > 0 && catergory <= count) {
                count = 0;
                for (int i = 0; i < detailsNumber; i++) {
                    if (details[i].isChosen) {
                        count++;
                        if (count == catergory) {
                            details[i].isChosen = false;
                        }
                    }
                }
            }
        } while (catergory != count + 1);
    }

    // private void quickSort(Detail[] details, int leftBorder, int rightBorder) {
    //     Detail pivot = details[leftBorder];
    //     int l = leftBorder, r = rightBorder;

	// for (; r >= l; r--) {
	// 	if (pivot.getPrice() >= details[r].getPrice()) {
	// 		details[l] = details[r];
	// 		details[r] = pivot;
	// 		l++;
	// 		for (; r >= l; l++) {
	// 			if (details[l].getPrice() >= pivot.getPrice()) {
	// 				details[r] = details[l];
	// 				details[l] = pivot;
	// 				break;
	// 			}
	// 		}
	// 	}
	// }
    //     if (r >= leftBorder) {
    //         quickSort(details, leftBorder, r);
    //     }
    //     if (l <= rightBorder) {
    //         quickSort(details, l, rightBorder);
    //     }
    // }

    public void sortDetails(Detail[] details) {
        //quickSort(details, 0, details.length - 1);
        details = Arrays.stream(details).sorted((o1, o2) -> o1.getPrice() - o2.getPrice()).collect(Collectors.toList()).toArray(details);
    }
}
