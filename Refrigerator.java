/**
 * Класс, представляющий холодильник с его основными характеристиками.
 */
public class Refrigerator {

    private String brand; // Бренд холодильника
    private String model; // Модель холодильника
    private int capacity; // Вместимость в литрах
    private double powerConsumption; // Потребление электроэнергии (кВт/ч)
    private double height; // Высота в метрах

    /**
     * Конструктор по умолчанию.
     */
    public Refrigerator() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.capacity = 0;
        this.powerConsumption = 0.0;
        this.height = 0.0;
    }

    /**
     * Конструктор с параметрами.
     *
     * @param brand            Бренд холодильника
     * @param model            Модель
     * @param capacity         Вместимость (л)
     * @param powerConsumption Потребление энергии (кВт/ч)
     * @param height           Высота (м)
     */
    public Refrigerator(String brand, String model, int capacity,
                        double powerConsumption, double height) {
        setBrand(brand);
        setModel(model);
        setCapacity(capacity);
        setPowerConsumption(powerConsumption);
        setHeight(height);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public double getHeight() {
        return height;
    }

    public void setBrand(String brand) {
        if (brand != null && !brand.trim().isEmpty()) {
            this.brand = brand;
        }
    }

    public void setModel(String model) {
        if (model != null && !model.trim().isEmpty()) {
            this.model = model;
        }
    }

    public void setCapacity(int capacity) {
        if (capacity >= 0) {
            this.capacity = capacity;
        }
    }

    public void setPowerConsumption(double powerConsumption) {
        if (powerConsumption >= 0) {
            this.powerConsumption = powerConsumption;
        }
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        }
    }

    /**
     * Определяет энергетический класс холодильника по потреблению энергии.
     *
     * @return строка с обозначением класса
     */
    public String getEnergyClass() {
        if (powerConsumption < 0.5) {
            return "A++";
        } else if (powerConsumption < 1.0) {
            return "A+";
        } else if (powerConsumption < 1.5) {
            return "A";
        } else {
            return "B";
        }
    }

    /**
     * Возвращает строковое представление объекта.
     *
     * @return строка с информацией о холодильнике
     */
    @Override
    public String toString() {
        return "Бренд: " + brand
                + ", Модель: " + model
                + ", Вместимость: " + capacity + " л"
                + ", Потребление энергии: " + powerConsumption + " кВт/ч"
                + ", Высота: " + height + " м"
                + ", Энергетический класс: " + getEnergyClass();
    }
}
