/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import commons.Common;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import models.Cart_Flight_Order;
import models.Cart_Packages_Order;
import models.PromoCode;
import models.User;
import repositories.CartRepository;
import repositories.OrderPackageRepository;
import repositories.OrderRepository;
import repositories.PromocodeRepository;
import repositories.TicketRepository;
import repositories.Ticket_FlightRepository;
import repositories.UserRepository;

/**
 * FXML Controller class
 *
 * @author gargi
 */
public class CheckoutController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private RadioButton rbMale;
    @FXML
    private RadioButton rbFemale;
    @FXML
    private RadioButton rbOther;
    @FXML
    private ComboBox cbCountry;
    @FXML
    private ComboBox cbExpYear;
    @FXML
    private ComboBox cbExpMonth;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtlastName;

    @FXML
    private TextField txtIdType;
    @FXML
    private TextField txtIdNumber;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtPostalCode;
    @FXML
    private TextField txtCardNumber;
    @FXML
    private TextField txtSecCode;

    @FXML
    private TextField txtPromocode;

    @FXML
    private Label lblReqLastName;

    @FXML
    private Label lblreqFirstName;
    @FXML
    private Label lblReqIDNumber;
    @FXML
    private Label lblreqAddress;
    @FXML
    private Label lblreqPostalCode;
    @FXML
    private Label lblReqCardNumber;
    @FXML
    private Label lblreqExpYear;
    @FXML
    private Label lblReqExpMonth;
    @FXML
    private Label lblReqSecurityCode;
    @FXML
    private Label lblReqCountry;
    @FXML
    private DatePicker dDatePicker;

    @FXML
    private Label lblReqIdExpDate;
    @FXML
    private Label lblValidPromoCode;
    @FXML
    private javafx.scene.control.Button closeButton;
//    @FXML
//    private Label txtSecCode;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final ToggleGroup group = new ToggleGroup();
        rbMale.setToggleGroup(group);
        rbFemale.setToggleGroup(group);
        rbOther.setToggleGroup(group);
        bindCountries();
        bindYear();
        bindUserDetails();

        // TODO
    }

    public void bindUserDetails() {
        User user = UserRepository.getClient(commons.Common.LOGGED_IN_USERID);
        if (user != null) {
            txtFirstName.setText(user.getGivenName());
            txtlastName.setText(user.getFamilyName());
            txtAddress.setText(user.getAddress());
            txtlastName.setText(user.getFamilyName());
        }
    }

    public void bindCountries() {
        List<String> countries = new ArrayList<>();
        countries.add("Afghanistan");
        countries.add("Albania");
        countries.add("Algeria");
        countries.add("Andorra");
        countries.add("Angola");
        countries.add("Antigua and Barbuda");
        countries.add("Argentina");
        countries.add("Armenia");
        countries.add("Australia");
        countries.add("Austria");
        countries.add("Azerbaijan");
        countries.add("Bahamas");
        countries.add("Bahrain");
        countries.add("Bangladesh");
        countries.add("Barbados");
        countries.add("Belarus");
        countries.add("Belgium");
        countries.add("Belize");
        countries.add("Benin");
        countries.add("Bhutan");
        countries.add("Bolivia");
        countries.add("Bosnia and Herzegovina");
        countries.add("Botswana");
        countries.add("Brazil");
        countries.add("Brunei");
        countries.add("Bulgaria");
        countries.add("Burkina Faso");
        countries.add("Burundi");
        countries.add("Cabo Verde");
        countries.add("Cambodia");
        countries.add("Cameroon");
        countries.add("Canada");
        countries.add("Central African Republic (CAR)");
        countries.add("Chad");
        countries.add("Chile");
        countries.add("China");
        countries.add("Colombia");
        countries.add("Comoros");
        countries.add("Democratic Republic of the Congo");
        countries.add("Republic of the Congo");
        countries.add("Costa Rica");
        countries.add("Cote d'Ivoire");
        countries.add("Croatia");
        countries.add("Cuba");
        countries.add("Cyprus");
        countries.add("Czech Republic");
        countries.add("Denmark");
        countries.add("Djibouti");
        countries.add("Dominica");
        countries.add("Dominican Republic");
        countries.add("Ecuador");
        countries.add("Egypt");
        countries.add("El Salvador");
        countries.add("Equatorial Guinea");
        countries.add("Eritrea");
        countries.add("Estonia");
        countries.add("Ethiopia");
        countries.add("Fiji");
        countries.add("Finland");
        countries.add("France");
        countries.add("Gabon");
        countries.add("Gambia");
        countries.add("Georgia");
        countries.add("Germany");
        countries.add("Ghana");
        countries.add("Greece");
        countries.add("Grenada");
        countries.add("Guatemala");
        countries.add("Guinea");
        countries.add("Guinea-Bissau");
        countries.add("Guyana");
        countries.add("Haiti");
        countries.add("Honduras");
        countries.add("Hungary");
        countries.add("Iceland");
        countries.add("India");
        countries.add("Indonesia");
        countries.add("Iran");
        countries.add("Iraq");
        countries.add("Ireland");
        countries.add("Israel");
        countries.add("Italy");
        countries.add("Jamaica");
        countries.add("Japan");
        countries.add("Jordan");
        countries.add("Kazakhstan");
        countries.add("Kenya");
        countries.add("Kiribati");
        countries.add("Kosovo");
        countries.add("Kuwait");
        countries.add("Kyrgyzstan");
        countries.add("Laos");
        countries.add("Latvia");
        countries.add("Lebanon");
        countries.add("Lesotho");
        countries.add("Liberia");
        countries.add("Libya");
        countries.add("Liechtenstein");
        countries.add("Lithuania");
        countries.add("Luxembourg");
        countries.add("Macedonia (FYROM)");
        countries.add("Madagascar");
        countries.add("Malawi");
        countries.add("Malaysia");
        countries.add("Maldives");
        countries.add("Mali");
        countries.add("Malta");
        countries.add("Marshall Islands");
        countries.add("Mauritania");
        countries.add("Mauritius");
        countries.add("Mexico");
        countries.add("Micronesia");
        countries.add("Moldova");
        countries.add("Monaco");
        countries.add("Mongolia");
        countries.add("Montenegro");
        countries.add("Morocco");
        countries.add("Mozambique");
        countries.add("Myanmar (Burma)");
        countries.add("Namibia");
        countries.add("Nauru");
        countries.add("Nepal");
        countries.add("Netherlands");
        countries.add("New Zealand");
        countries.add("Nicaragua");
        countries.add("Niger");
        countries.add("Nigeria");
        countries.add("North Korea");
        countries.add("Norway");
        countries.add("Oman");
        countries.add("Pakistan");
        countries.add("Palau");
        countries.add("Palestine");
        countries.add("Panama");
        countries.add("Papua New Guinea");
        countries.add("Paraguay");
        countries.add("Peru");
        countries.add("Philippines");
        countries.add("Poland");
        countries.add("Portugal");
        countries.add("Qatar");
        countries.add("Romania");
        countries.add("Russia");
        countries.add("Rwanda");
        countries.add("Saint Kitts and Nevis");
        countries.add("Saint Lucia");
        countries.add("Saint Vincent and the Grenadines");
        countries.add("Samoa");
        countries.add("San Marino");
        countries.add("Sao Tome and Principe");
        countries.add("Saudi Arabia");
        countries.add("Senegal");
        countries.add("Serbia");
        countries.add("Seychelles");
        countries.add("Sierra Leone");
        countries.add("Singapore");
        countries.add("Slovakia");
        countries.add("Slovenia");
        countries.add("Solomon Islands");
        countries.add("Somalia");
        countries.add("South Africa");
        countries.add("South Korea");
        countries.add("South Sudan");
        countries.add("Spain");
        countries.add("Sri Lanka");
        countries.add("Sudan");
        countries.add("Suriname");
        countries.add("Swaziland");
        countries.add("Sweden");
        countries.add("Switzerland");
        countries.add("Syria");
        countries.add("Taiwan");
        countries.add("Tajikistan");
        countries.add("Tanzania");
        countries.add("Thailand");
        countries.add("Timor-Leste");
        countries.add("Togo");
        countries.add("Tonga");
        countries.add("Trinidad and Tobago");
        countries.add("Tunisia");
        countries.add("Turkey");
        countries.add("Turkmenistan");
        countries.add("Tuvalu");
        countries.add("Uganda");
        countries.add("Ukraine");
        countries.add("United Arab Emirates (UAE)");
        countries.add("United Kingdom (UK)");
        countries.add("United States of America (USA)");
        countries.add("Uruguay");
        countries.add("Uzbekistan");
        countries.add("Vanuatu");
        countries.add("Vatican City (Holy See)");
        countries.add("Venezuela");
        countries.add("Vietnam");
        countries.add("Yemen");
        countries.add("Zambia");
        countries.add("Zimbabwe");
        cbCountry.getItems().addAll(FXCollections.observableArrayList(countries));
    }

    private void bindYear() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        List<Integer> yearList = new ArrayList<>();
        for (int i = year; i < year + 20; i++) {
            yearList.add(i);
        }
        cbExpYear.getItems().addAll(FXCollections.observableArrayList(yearList));

    }

    @FXML
    public void bindCbMonth(ActionEvent evt) throws Exception {
        try {
            Calendar now = Calendar.getInstance();
            int year = Integer.parseInt(cbExpYear.getSelectionModel().getSelectedItem().toString());
            int currentMonth = now.get(Calendar.MONTH) + 1;
            List<Integer> cbMonth = new ArrayList<>();
            if (year == now.get(Calendar.YEAR)) {

                cbExpMonth.getItems().clear();
                for (int i = currentMonth; i <= 12; i++) {
                    cbMonth.add(i);
                }
                cbExpMonth.getItems().addAll(cbMonth);

            } else {
                cbExpMonth.getItems().clear();
                for (int i = 1; i <= 12; i++) {
                    cbMonth.add(i);
                }
                cbExpMonth.getItems().addAll(cbMonth);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    public void btnPlaceOrderClick(ActionEvent evt) {
        try {
            boolean validFname = false;
            boolean validlname = false;
            boolean validIDNo = false;
            boolean validCountry = false;
            boolean validAddress = false;
            boolean validPostalCode = false;
            boolean validCardNumber = false;
            boolean validExpMonth = false;
            boolean validExpYear = false;
            boolean validSecCode = false;
            boolean validPassportExpDate = false;
            boolean validCreditCardNumber = false;

            if (txtFirstName.getText().isEmpty()) {
                lblreqFirstName.setVisible(true);
                lblreqFirstName.setText("* Required");

            } else {
                lblreqFirstName.setVisible(false);
                lblreqFirstName.setText("");
                validFname = true;
            }

            if (dDatePicker.getValue() == null) {
                lblReqIdExpDate.setVisible(true);
                lblReqIdExpDate.setText("* Required");

            } else {
                lblReqIdExpDate.setVisible(false);
                lblReqIdExpDate.setText("");
                validPassportExpDate = true;
            }
            if (txtlastName.getText().isEmpty()) {
                lblReqLastName.setVisible(true);
                lblReqLastName.setText("* Required");

            } else {
                lblReqLastName.setVisible(false);
                lblReqLastName.setText("");
                validlname = true;
            }

            if (txtIdNumber.getText().isEmpty()) {
                lblReqIDNumber.setVisible(true);
                lblReqIDNumber.setText("* Required");

            } else {
                lblReqIDNumber.setVisible(false);
                lblReqIDNumber.setText("");
                validIDNo = true;
            }
            if (txtAddress.getText() == null || txtAddress.getText().isEmpty()) {
                lblreqAddress.setVisible(true);
                lblreqAddress.setText("* Required");

            } else {
                lblreqAddress.setVisible(false);
                lblreqAddress.setText("");
                validAddress = true;
            }
            if (cbCountry.getSelectionModel().isEmpty()) {
                lblReqCountry.setVisible(true);
                lblReqCountry.setText("* Required");

            } else {
                lblReqCountry.setVisible(false);
                lblReqCountry.setText("");
                validCountry = true;
            }
            if (cbExpMonth.getSelectionModel().isEmpty()) {
                lblReqExpMonth.setVisible(true);
                lblReqExpMonth.setText("* Required");

            } else {
                lblReqExpMonth.setVisible(false);
                lblReqExpMonth.setText("");
                validExpMonth = true;
            }
            if (cbExpYear.getSelectionModel().isEmpty()) {
                lblreqExpYear.setVisible(true);
                lblreqExpYear.setText("* Required");

            } else {
                lblreqExpYear.setVisible(false);
                lblreqExpYear.setText("");
                validExpYear = true;
            }
            if (txtPostalCode.getText().isEmpty()) {
                lblreqPostalCode.setVisible(true);
                lblreqPostalCode.setText("* Required");

            } else {
                lblreqPostalCode.setVisible(false);
                lblreqPostalCode.setText("");
                validPostalCode = true;
            }
            if (txtCardNumber.getText().isEmpty()) {
                lblReqCardNumber.setVisible(true);
                lblReqCardNumber.setText("* Required");
            } else {
                if (validCCNumber(txtCardNumber.getText())) {
                    lblReqCardNumber.setVisible(false);
                    lblReqCardNumber.setText("");
                    validCardNumber = true;
                } else {
                    lblReqCardNumber.setVisible(true);
                    lblReqCardNumber.setText("Invalid Credit Card Number");
                    validCardNumber = false;
                }
            }
            if (txtSecCode.getText().isEmpty()) {
                lblReqSecurityCode.setVisible(true);
                lblReqSecurityCode.setText("* Required");

            } else {

                lblReqSecurityCode.setVisible(false);
                lblReqSecurityCode.setText("");
                validSecCode = true;

            }
            double total = 0.0;
            if (!txtPromocode.getText().isEmpty()) {

                PromoCode pc;
                pc = getPromoCode(txtPromocode.getText());
                if (pc != null) {
                    double discount = (Common.CART_TOTAL_BEFORE_PROMO * pc.getDiscount()) / 100;
                    total = Common.CART_TOTAL_BEFORE_PROMO - discount;
                    lblValidPromoCode.setText("");

                } else {
                    lblValidPromoCode.setText("Invalid Promo Code");
                    total = Common.CART_TOTAL_BEFORE_PROMO;
                }
            } else {
                total = Common.CART_TOTAL_BEFORE_PROMO;
            }

            if (validPassportExpDate == true && validFname == true & validlname == true && validIDNo == true && validCountry == true && validAddress == true && validPostalCode == true && validCardNumber == true && validExpMonth == true && validExpYear == true && validSecCode == true) {
                Date gettedDatePickerDate = java.sql.Date.valueOf(dDatePicker.getValue());
                UserRepository.updateUser(txtFirstName.getText(), txtlastName.getText(), Common.LOGGED_IN_USERID, txtAddress.getText(), txtPostalCode.getText(), cbCountry.getSelectionModel().getSelectedItem().toString(), txtIdNumber.getText(), gettedDatePickerDate);

                LocalDateTime ldt = LocalDateTime.now().plusDays(1);
                String string = ldt.toLocalDate().toString();
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date date = format.parse(string);

//               
//                DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
//                String d = formmat1.format(ldt);
//                SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");  
//                Date date1=formatter1.parse(d);
                String orderId = OrderRepository.createOrder(date, txtPromocode.getText(), Common.LOGGED_IN_USERID);
                if (!orderId.equals("")) {
                    createOrderTickets(orderId);
                    createOrderPackage(orderId);
                    
                    Alert alert = new Alert(AlertType.INFORMATION, "Your credit card has been charged $" + total + ".");
                    alert.showAndWait();
                    Stage stage = (Stage) lblReqIdExpDate.getScene().getWindow();
                    stage.close();
                }

            } else {

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    /*
     * Visa : 13 or 16 digits, starting with 4.
     *MasterCard : 16 digits, starting with 51 through 55.
     *Discover : 16 digits, starting with 6011 or 65.
     *American Express : 15 digits, starting with 34 or 37.
     *Diners Club : 14 digits, starting with 300 through 305, 36, or 38.
     *JCB : 15 digits, starting with 2131 or 1800, or 16 digits starting with 35.
     */

    public boolean validCCNumber(String ccNumber) {
        String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|"
                + "(?<mastercard>5[1-5][0-9]{14})|"
                + "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|"
                + "(?<amex>3[47][0-9]{13})|"
                + "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|"
                + "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";

        Pattern pattern = Pattern.compile(regex);
        ccNumber = ccNumber.replaceAll("-", "");
        Matcher matcher = pattern.matcher(ccNumber);
        if (matcher.matches()) {
            return true;
        }
        return false;

    }

    public boolean checkCVV(String cvv) {
        String regex = "/^[0-9]{3,4}$/";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cvv);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    public PromoCode getPromoCode(String promocode) {
        PromoCode code = PromocodeRepository.getPromoCode(promocode);
        return code;
    }

    public boolean createOrderTickets(String orderId) {
        String ticket_Number = "";
        boolean result = false;
        try {
            List<Cart_Flight_Order> cartFlights = CartRepository.getCartFlights(Common.LOGGED_IN_USERID);
            if (cartFlights == null || cartFlights.isEmpty()) {
            } else {
                for (Cart_Flight_Order cfo : cartFlights) {
                    ticket_Number = TicketRepository.createTicket(cfo.getEconomyPrice(), txtPromocode.getText(), Common.LOGGED_IN_USERID, orderId);
                    if (!ticket_Number.equals("")) {
                        boolean check = Ticket_FlightRepository.createTicketFlight(ticket_Number, cfo.getFlightNumber());
                        result = check;

                    } else {
                        result = false;
                    }
                }
            }

        } catch (Exception ex) {
        }
        return result;

    }

    public boolean createOrderPackage(String orderId) {
        String ticket_Number = "";
        boolean result = false;
        try {
            List<Cart_Packages_Order> cart_Packages_Orders = CartRepository.getCartPackages(Common.LOGGED_IN_USERID);
            if (cart_Packages_Orders == null || cart_Packages_Orders.isEmpty()) {
            } else {
                for (Cart_Packages_Order cfo : cart_Packages_Orders) {
                    result = OrderPackageRepository.createOrderPackage(orderId, Integer.parseInt(cfo.getPackageID()));

                }
            }

        } catch (Exception ex) {
        }
        return result;

    }

}
