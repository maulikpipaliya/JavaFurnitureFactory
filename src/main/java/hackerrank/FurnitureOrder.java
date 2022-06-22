package hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FurnitureOrder implements FurnitureOrderInterface {

    private final HashMap<Furniture, Integer> furnitures;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        furnitures = new HashMap<Furniture, Integer>();
    }

    /**
     * @param type  The type of Furniture being added to the order.
     * @param count The number of units of Furniture type 'type' to add to the
     *              order.
     */
    public void addToOrder(final Furniture type, final int furnitureCount) {
        Integer count = 0;
        if (furnitures.containsKey(type)) {
            count = furnitures.get(type);
        }
        Integer newCount = count + furnitureCount;
        furnitures.put(type, newCount);
    }

    /**
     * @return All the ordered furniture as a mapping of Furniture types to Integer
     *         quantities.
     */
    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return new HashMap<Furniture, Integer>(furnitures);
    }

    /**
     * @param type The type of Furniture
     * @return The total number of units of Furniture 'type' in the order.
     */
    public int getTypeCount(Furniture type) {
        return furnitures.getOrDefault(type, 0);
    }

    /**
     *
     * @param type The type of Furniture being ordered
     * @return The total cost of just the Furniture units of 'type' in the order.
     */
    public float getTypeCost(Furniture type) {
        if (furnitures.containsKey(type))
            return furnitures.get(type) * type.cost();
        return 0.0f;
    }

    /**
     * @return The total cost of the order.
     */
    public float getTotalOrderCost() {
        if (!furnitures.isEmpty()) {

            List<Float> list = furnitures.entrySet().stream()
                    .map(f -> f.getKey().cost() * f.getValue())
                    .collect(Collectors.toList());
            float sum = list.stream()
                    .reduce(Float::sum)
                    .get();
            return sum;
        }
        return 0.0f;
    }

    /**
     * @return The total number of all types of Furniture units in the order.
     */
    public int getTotalOrderQuantity() {
        if (!furnitures.isEmpty()) {
            int sum = furnitures.values().stream()
                    .reduce(Integer::sum)
                    .get();
            return sum;
        }
        return 0;
    }
}