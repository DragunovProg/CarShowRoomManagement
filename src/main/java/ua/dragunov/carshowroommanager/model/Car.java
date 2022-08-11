package ua.dragunov.carshowroommanager.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String mark;
    @Column(nullable = false)
    private String model;
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;
    @Column(nullable = false)
    private String engine;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private int quantity;

    @OneToMany(mappedBy = "car", cascade = {CascadeType.MERGE
            , CascadeType.PERSIST
            , CascadeType.DETACH
            , CascadeType.REFRESH})
    List<CarSales> carSalesList;

    public List<CarSales> getCarSalesList() {
        return carSalesList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getId(), car.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", releaseDate=" + releaseDate +
                ", engine='" + engine + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
