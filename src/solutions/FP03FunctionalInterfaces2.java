package solutions;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03FunctionalInterfaces2 {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);

        // Boolean comparison
        Predicate<Integer> isEvenPredicate = x -> x%2==0;

        Function<Integer, Integer> squareFunction = x-> x*x;

        // Input & output defined of the function
        Function<Integer, String> stringOutputFunction = x -> x + "";

        // Consumer only processes
        Consumer<Integer> sysoutConsumer = System.out::println;

        // All operands must be of the same type
        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;

        // No parameters, a simple factory method
        //Supplier<Integer> randomIntegerSupplier = () -> 2;

        // No parameters, a simple factory method multiline body
        Supplier<Integer> randomIntegerSupplier = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };
        //System.out.println(randomIntegerSupplier.get());

        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;
        //System.out.println(unaryOperator.apply(10));

        BiPredicate<Integer, Integer> bothEven = (a, b) -> (a % 2 == 0) && (b % 2 == 0);
        //System.out.println(bothEven.test(1, 2)); // false


        String producto = "Café Latte";
        double precioBase = 3.50;

        // 1. BIPREDICATE: Solo responde SI o NO
        // ¿El precio supera el límite de un producto "Premium"?
        BiPredicate<String, Double> esCafePremium = (prod, precio) -> (prod.contains("Café")) && (precio > 5.00);

        // 2. BIFUNCTION: Transforma las dos entradas en un NUEVO resultado
        // Aplica un impuesto al precio y nos devuelve un ticket formateado (String)
        BiFunction<String, Double, String> generarTicket = (prod, precio) -> {
            double precioFinal = precio * 1.21; // Sumamos 21% de IVA
            return "Ticket: " + prod + " - Total con IVA: $" + precioFinal;
        };

        // 3. BICONSUMER: Recibe los dos datos, hace algo con ellos y NO devuelve nada
        // Imprime en la pantalla de la cocina el pedido para que el barista lo prepare
        BiConsumer<String, Double> enviarACocina = (prod, precio) -> {
            System.out.println("[COCINA] Preparando: " + prod + " (Valorizado en $" + precio + ")");
        };

        // Evaluamos con el BiPredicate
        boolean premium = esCafePremium.test(producto, precioBase);
        System.out.println("¿Es un café premium?: " + premium); // false (cuesta 3.50)

        // Usamos el BiConsumer para ejecutar una acción
        enviarACocina.accept(producto, precioBase); // Imprime el mensaje

        // Usamos la BiFunction para obtener el String procesado
        String ticketFinal = generarTicket.apply(producto, precioBase);
        System.out.println(ticketFinal); // Imprime el ticket con el IVA calculado
    }
}
