/**
 * Week 1 - Problem 4: The Warehouse Inventory Balancer
 *
 * Compares total quantities between two warehouse sections and finds the
 * single highest quantity value across both sections.
 */
public class WarehouseInventoryBalancer {

    /**
     * Computes the total quantity in each section, reports whether the
     * sections are balanced, and finds the highest quantity value across
     * both sections along with which section and item it belongs to.
     *
     * @param sectionA item quantities in Section A
     * @param sectionB item quantities in Section B (same length as sectionA)
     */
    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
        }

        int totalB = 0;
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        // Scan Section A first, then Section B, so that on a tie the
        // earliest occurrence is kept as the reported highest quantity.
        int highestQuantity = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0; // 0-based; displayed below as (index + 1)

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        System.out.println("Section A Total: " + totalA +
                " | Section B Total: " + totalB +
                " | Status: " + status +
                " | Highest Quantity: " + highestQuantity +
                " (" + highestSection + ", Item " + (highestIndex + 1) + ")");
    }

    public static void main(String[] args) {
        System.out.println("Input: sectionA={20,15,30}, sectionB={25,10,30}");
        analyzeInventory(new int[] {20, 15, 30}, new int[] {25, 10, 30});
    }
}
