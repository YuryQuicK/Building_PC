import java.util.Scanner;

class detail {
    private String name;
    private int price;
    public boolean isChosen;

    public detail() {
        name = "";
        price = 0;
        isChosen = false;
    }

    public detail(String name, int price) {
        this.name = name;
        this.price = price;
        isChosen = false;
    }

    public void setDetail(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void showDetail() {
        System.out.println(name + "\tЦена:" + price + " рублей");
    }

    public int getPrice() {
        return price;
    }
}

public class PC {
    detail[] details;
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
                    pc.chooseCategory(pc.details, console);
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
        details = new detail[8];
        details[0] = new detail(new String("Процессор: i5-3770K"), 5000);
        details[1] = new detail(new String("Материнская плата: Asus Z77-A"), 8000);
        details[2] = new detail(new String("Видеокарта: GeForce GTX 1060 G1 Gaming 6GB"), 16000);
        details[3] = new detail(new String("Оперативная память: Crucial Balistix 8 GB"), 6000);
        details[4] = new detail(new String("Корпус: DEEPCOOLMATREXX 30"), 2800);
        details[5] = new detail(new String("Блок питания: POWERMAN 450W"), 3000);
        details[6] = new detail(new String("Охлаждение компьютера: DEEPCOOL GAMMAX 400"), 2500);
        details[7] = new detail(new String("HDD диск/SSD накопитель: WD BLUE 1TB"), 3500);
    }

    public void showChoosen(detail[] details) {
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

    public void chooseCategory(detail[] details, Scanner console) {
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

    public void deleteCategory(detail[] details, Scanner console) {
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

    private void quickSort(detail[] details, int leftBorder, int rightBorder) {
        detail pivot = details[leftBorder];
        int l = leftBorder, r = rightBorder;

	for (; r >= l; r--) {
		if (pivot.getPrice() >= details[r].getPrice()) {
			details[l] = details[r];
			details[r] = pivot;
			l++;
			for (; r >= l; l++) {
				if (details[l].getPrice() >= pivot.getPrice()) {
					details[r] = details[l];
					details[l] = pivot;
					break;
				}
			}
		}
	}
	if (r >= leftBorder) {
		quickSort(details, leftBorder, r);
	}
	if (l <= rightBorder) {
		quickSort(details, l, rightBorder);
	}
    }

    public void sortDetails(detail[] details) {
        quickSort(details, 0, details.length - 1);
    }
}
