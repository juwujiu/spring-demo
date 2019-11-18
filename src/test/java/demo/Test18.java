package demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.io.WKTReader;
import com.vividsolutions.jts.io.WKTWriter;
import com.vividsolutions.jts.operation.polygonize.Polygonizer;

public class Test18 {
    private static GeometryFactory GF = new GeometryFactory();
    private static WKTWriter writer = new WKTWriter();
    private static WKTReader reader = new WKTReader();

    public static void main(String[] args) throws Exception {
        // Coordinate c1 = new Coordinate(1.0, 2.0, 3.0);
        // Coordinate c2 = new Coordinate(1.1, 2.3, 3.1);
        // Coordinate c3 = new Coordinate(1.5, 2.7, 3.2);
        // Coordinate c4 = new Coordinate(1.2, 2.4, 3.3);
        // Coordinate[] coordinates = {c1, c2, c3, c4};
        List<Geometry> list = new ArrayList<Geometry>();
        list.add(reader.read("LINESTRING (0 0,1 1)"));
        list.add(reader.read("LINESTRING (6 3,6 10)"));
        list.add(reader.read("LINESTRING (2 2,4 4,6 3)"));
        list.add(reader.read("LINESTRING (2 2,5 1,6 3)"));
        list.add(reader.read("LINESTRING (6 3,6 4)"));
        list.add(reader.read("LINESTRING (9 5,7 1,6 4)"));
        list.add(reader.read("LINESTRING (9 5,8 8,6 4)"));
        Polygonizer p = new Polygonizer();
        p.add(list);
        Collection<Geometry> polys = p.getPolygons(); // 面
        Collection<Geometry> dangles = p.getDangles();// 悬挂线
        Collection<Geometry> cuts = p.getCutEdges(); // 面和面的连接线
        System.out.println(polys.size() + ":" + polys.toString());
        System.out.println(dangles.size() + ":" + dangles.toString());
        System.out.println(cuts.size() + ":" + cuts.toString());
    }
}
