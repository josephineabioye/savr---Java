package savr.service;

import savr.model.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class AutoDebitService {
    private List<AutoDebit> autoDebits = new ArrayList<>();

    public void addAutoDebit(AutoDebit autoDebit) {
        autoDebits.add(autoDebit);
    }

    public List<AutoDebit> getAllAutoDebits() {
        return autoDebits;
    }





}
