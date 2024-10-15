package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Sidebar {
    private WebDriver driver;
    private WebDriverWait wait;

    public Sidebar(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickItem(String parentName) {
        clickItem(parentName, null);
    }

    public void clickItem(String parentName, String childName) {
        if (parentName == null || parentName.isEmpty()) {
            throw new IllegalArgumentException("Parent name cannot be null or empty");
        }

        List<WebElement> parents = driver.findElements(By.xpath("//div[@class='left-bar hidden-print']//ul/li"));
        boolean parentClicked = false;

        for (WebElement parent : parents) {
            String text = parent.getText().trim();
            if (text.equals(parentName)) {
                parent.click();
                parentClicked = true;
                System.out.println("Clicked on parent: " + parentName);

                // If a child name is provided, search and click the child item
                if (childName != null && !childName.isEmpty()) {
                    List<WebElement> children = parent.findElements(By.xpath(".//ul/li"));
                    boolean childClicked = false;
                    for (WebElement child : children) {
                        String childText = child.getText().trim();
                        if (childText.equals(childName)) {
                            child.click();
                            childClicked = true;
                            System.out.println("Clicked on child: " + childName);
                            break;
                        }
                    }
                    if (!childClicked) {
                        System.err.println("Child item '" + childName + "' not found under parent '" + parentName + "'.");
                    }
                }
                break;
            }
        }

        if (!parentClicked) {
            System.err.println("Parent item '" + parentName + "' not found.");
        }
    }
}
