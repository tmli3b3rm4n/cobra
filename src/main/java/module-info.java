//module com.cobras.example.demo_cobras {
//    requires javafx.controls;
//    requires javafx.fxml;
//
//    requires org.controlsfx.controls;
//    requires com.dlsc.formsfx;
//    requires org.kordamp.bootstrapfx.core;
//
//    opens com.cobras.example.demo_cobras to javafx.fxml;
//    exports com.cobras.example.demo_cobras;
//}

module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.cobras.example.demo_cobras to javafx.fxml;
    exports com.cobras.example.demo_cobras;

}