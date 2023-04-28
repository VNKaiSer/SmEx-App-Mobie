package com.example.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.entity.Plan;
import com.example.smex_app_android.R;

import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;

public class AdapterPlan extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Plan> listPlan;
    private boolean isEnable = false;
    private String previousPrice = "";


    public AdapterPlan(Context context, int layout, List<Plan> listPlan) {
        this.context = context;
        this.layout = layout;
        this.listPlan = listPlan;
    }

    public void setEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

    public boolean isEnable() {
        return isEnable;
    }

    @Override
    public int getCount() {
        return listPlan.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "SetTextI18n"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);
        Plan plan = listPlan.get(i);

        TextView title = view.findViewById(R.id.titlePlan);
        TextView price = view.findViewById(R.id.pricePlan);
        SeekBar seekBar = view.findViewById(R.id.seekbar);


        title.setText(plan.getTitle());
        price.setText("$" + plan.getPrice());
        seekBar.setProgress(plan.getPrice());


        if (isEnable) {
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    int interval = 10;
                    int roundedProgress = ((int) Math.round(progress / interval)) * interval;
                    seekBar.setProgress(roundedProgress);

                    String newPrice = roundedProgress + "";
                    if (roundedProgress >= 1000) {
                        String temp = "";
                        int count = 0;
                        for (int j = newPrice.length() - 1; j >= 0; j--) {
                            temp = newPrice.charAt(j) + temp;
                            count++;
                            if (count == 3 && j != 0) {
                                temp = "," + temp;
                                count = 0;
                            }
                        }
                        newPrice = temp;
                    }

                    price.setText("$" + newPrice);
                    plan.setPrice(roundedProgress);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    // Called when the user starts interacting with the SeekBar
                    System.out.println("start");
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    // Called when the user stops interacting with the SeekBar
                }
            });
        } else {
            seekBar.setEnabled(false);
            ColorFilter filter = new LightingColorFilter(Color.GRAY, Color.GRAY);
            seekBar.getProgressDrawable().setColorFilter(filter);
            seekBar.getThumb().setColorFilter(filter);
        }
        String currentPrice = plan.getPrice() + "";
        if (plan.getPrice() >= 1000) {
            String temp = "";
            int count = 0;
            for (int j = currentPrice.length() - 1; j >= 0; j--) {
                temp = currentPrice.charAt(j) + temp;
                count++;
                if (count == 3 && j != 0) {
                    temp = "," + temp;
                    count = 0;
                }
            }
            currentPrice = temp;
        }


        price.setText("$" + currentPrice);


        updatePlanPrice(plan.getTitle(), plan.getPrice(), context);


        return view;
    }

    public void updatePlanPrice(String title, int new_price, Context ctx) {

        try {
            File directory = ctx.getFilesDir();
            File file = new File(directory, "planDOM.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            NodeList nodeList = doc.getElementsByTagName("plan");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String planTitle = element.getElementsByTagName("title").item(0).getTextContent();
                    if (planTitle.equals(title)) {
                        element.getElementsByTagName("price").item(0).setTextContent(Integer.toString(new_price));
                        break;
                    }
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);

        } catch (ParserConfigurationException | IOException | TransformerException |
                 org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
    }

}
