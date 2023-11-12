# EnhancedUI
## Setup EnhancedUI

# :warning: Repository is currently not available due of server switch!

2.  Create an instance of `UIHolder.java` in your main class
    ```java
    private final UIHolder uiHolder = new UIHolder();
    ```

## Using EnhancedUI (ChestUI)
Now everything is ready to start. To create the first Chest UI you have to extend `ChestUI` in a class.
```java
public class TestUI extends ChestUI {  
  public TestUI(Component uiTitle, UIRow rows, Player opener) {  
    super(uiTitle, rows, opener);  
  }  
  
  @Override  
 public boolean allowItemMovementInOtherInventories() {  
    return false;  
  }  
  
  @Override  
 protected void initItems(Player opener) throws OutOfInventoryException {  
  
  }  
}
```
This is the default example of a ChestUI

### Constructor
| Title | UIRow | Player |
|--|--| -- |
| Component from the kyori adventure api | The rows that the ui have | the player that is the source to generate the items |
### Methods
#### allowItemMovementInOtherInventories
This method requires a boolean. If the boolean is true, the player can move the items in other inventories like the player inventory
#### initItems
In this method all items should be inserted. Any other items that inserted outside of this method can cause errors

### Adding items to the ChestUI

Items can be added in the initItems method.

To create an Item you have to create an UIItem this requires an `ItemStack` and a `UISlot` to put this item in.
> WARNING - In some cases the slot can be ignored

If the slot is outside of the ui then the libary will throw a *OutOfInventoryException*

```java
ItemStack itemStack = new ItemStack(Material.CHEST);    
item(new UIItem(itemStack, UISlot.SLOT_0), uiAction);
```
Now you can "listen" to this item with the `UIAction` class. Everytime the item is clicked, this code will be executed
```java
UIAction uiAction = (clicker, clickedItem, action) -> {  
  clicker.sendMessage("Clicked item " + clickedItem.buildItem().displayName());  
  return true;  
}; 
```
The method requires a boolean to return if the boolean is true the event will be canceld.

| clicker | clickedItem | action |
|--|--| -- |
| the player that clicked the item | the item that has been clicked on | the bukkit action if it is at example a left or right click |

## Using EnhancedUI (AnvilUI)
comming soon...

