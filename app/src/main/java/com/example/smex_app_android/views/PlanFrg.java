package com.example.smex_app_android.views;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.adapter.AdapterPlan;
import com.example.entity.Plan;
import com.example.smex_app_android.R;
import com.example.smex_app_android.services.UserService;
import com.example.smex_app_android.services.impl.UserServiceImpl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class PlanFrg extends Fragment {

    private boolean isEnable = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_plan, container, false);

        ListView listView;
        List<Plan> listPlan;
        AdapterPlan adapterPlan;
        Button btnEnable = view.findViewById(R.id.btnEnable);


        listView = view.findViewById(R.id.listPlan);


        listPlan = new ArrayList<>();
        TextView hanMucChiTieu = view.findViewById(R.id.hanMucChiTieu);
        UserService service = new UserServiceImpl(getContext());
//        int money = service.getMoney();



        try {
            File directory = getContext().getFilesDir();
            File file = new File(directory, "planDOM.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            FileInputStream inputStream = new FileInputStream(file);
            Document doc = dBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();
            NodeList employeeElements = doc.getElementsByTagName("plan");
            for (int i = 0; i < employeeElements.getLength(); i++) {
                Element element = (Element) employeeElements.item(i);
                String title = element.getElementsByTagName("title").item(0).getTextContent();
                String price = element.getElementsByTagName("price").item(0).getTextContent();
                Plan plan = new Plan(title, Integer.parseInt(price));
                listPlan.add(plan);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        int currentMoney = 0;
        for (Plan plan : listPlan) {
            currentMoney += plan.getPrice();
        }
        String currentPrice = String.valueOf(currentMoney);
        if (currentMoney >= 1000) {
            StringBuilder temp = new StringBuilder();
            int count = 0;
            for (int j = currentPrice.length() - 1; j >= 0; j--) {
                temp.insert(0, currentPrice.charAt(j));
                count++;
                if (count == 3 && j != 0) {
                    temp.insert(0, ",");
                    count = 0;
                }
            }
            currentPrice = temp.toString();
        }

        hanMucChiTieu.setText("$" + currentPrice);
        adapterPlan = new AdapterPlan(getContext(), R.layout.plan, listPlan);
        listView.setAdapter(adapterPlan);
        View parentView = adapterPlan.getView(0, null, listView);


        btnEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isEnable = !isEnable;
                adapterPlan.setEnable(isEnable);
                adapterPlan.notifyDataSetChanged();
                int totalMoney = 0;

                try {
                    File directory = getContext().getFilesDir();
                    File file = new File(directory, "planDOM.xml");
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    FileInputStream inputStream = new FileInputStream(file);
                    Document doc = dBuilder.parse(inputStream);
                    doc.getDocumentElement().normalize();
                    NodeList employeeElements = doc.getElementsByTagName("plan");
                    for (int i = 0; i < employeeElements.getLength(); i++) {
                        Element element = (Element) employeeElements.item(i);
                        String price = element.getElementsByTagName("price").item(0).getTextContent();
                        totalMoney += Integer.parseInt(price);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (isEnable) {
                    btnEnable.setText("Đóng");
                } else {
                    btnEnable.setText("Mở");
                    String currentPrice = String.valueOf(totalMoney);
                    if (totalMoney >= 1000) {
                        StringBuilder temp = new StringBuilder();
                        int count = 0;
                        for (int j = currentPrice.length() - 1; j >= 0; j--) {
                            temp.insert(0, currentPrice.charAt(j));
                            count++;
                            if (count == 3 && j != 0) {
                                temp.insert(0, ",");
                                count = 0;
                            }
                        }
                        currentPrice = temp.toString();
                    }


                    hanMucChiTieu.setText("$" + currentPrice);
                }

            }
        });

        return view;
    }
}