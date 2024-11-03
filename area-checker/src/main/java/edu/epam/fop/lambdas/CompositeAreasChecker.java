package edu.epam.fop.lambdas;

import edu.epam.fop.lambdas.area.HalfPlane;
import edu.epam.fop.lambdas.area.Rectangle;
import edu.epam.fop.lambdas.area.Triangle;

import java.util.function.Predicate;

public interface CompositeAreasChecker {

  static Predicate<Point> task1() {
    Point pA = Point.p(0.0, 1.0);
    Point pB = Point.p(-3.0, -1.0);
    Point cCenter = Point.p(-0.5, 0.5);
    double radius = 1.5;
    Line ox = Line.OX();
    Line oy = Line.OY();
    Line lineAB = Line.l(pA, pB);

    Predicate<Point> quadrantII = point -> {
      double distance = Point.length(cCenter, point);
      HalfPlane rightOx = HalfPlane.onTheRight(ox);

      HalfPlane rightOy = HalfPlane.onTheRight(oy);
      return distance <= radius &&
              rightOx.test(true).test(point)
              && rightOy.test(true).test(point);

    };
    Predicate<Point> quadrantIII = point -> {
      double distance = Point.length(cCenter, point);
      HalfPlane rightOx = HalfPlane.onTheRight(ox);
      HalfPlane rightAb = HalfPlane.onTheRight(lineAB);
      return distance <= radius
              && rightOx.test(true).test(point)
              && rightAb.test(true).test(point);
    };

    Predicate<Point> quadrantI = point -> {
      double distance = Point.length(cCenter, point);
      HalfPlane rightOy = HalfPlane.onTheRight(Line.OY());
      HalfPlane leftAb = HalfPlane.onTheRight(lineAB);

      return distance <= radius
              && rightOy.test(true).test(point)
              && leftAb.test(true).test(point);
    };

    Predicate<Point> triangle = point -> {
      Point pCrossOxAB = Point.p(-1.5, 0);
      Triangle t = Triangle.t(pA, Point.p0(), pCrossOxAB);
      return t.test(point);
    };
    return  quadrantIII.or(quadrantII).or(quadrantI).or(triangle);
  }


  static Predicate<Point> task2() {
    Point pA = Point.p(-1.0, 1.5);
    Point pB = Point.p(1.5, 3.0);
    Point pC = Point.p(2.0, 2.25);
    Point pD = Point.p(2.0, 3.0);
    Point pP = Point.p(0.5, 0.0);
    Line lineAB =Line.l(pA, pB);
    Line lineAC =Line.l(pA, pC);
    Line linePYp = Line.y(pP.x());

    Rectangle rectangle = Rectangle.r(pA, pD);
    Triangle trBCD = Triangle.t(pB ,pC ,pD);

    Predicate<Point>leftHalfPlane = point -> {
      HalfPlane rightAB = HalfPlane.onTheRight(lineAB);
      HalfPlane leftPYp = HalfPlane.onTheLeft(linePYp);
      HalfPlane leftAC = HalfPlane.onTheLeft(lineAC);
      return rectangle.test(false).test(point)
              && leftPYp.test(true).test(point)
              && leftAC.test(true).test(point)
              && rightAB.test(true).test(point);
    };

    Predicate<Point>rightHalfPlaneLeftTriangle = point -> {
      HalfPlane leftAB = HalfPlane.onTheLeft(lineAB);
      HalfPlane rightPYp = HalfPlane.onTheRight(linePYp);
       return  rectangle.test(false).test(point)
               && leftAB.test(false).test(point)
               && rightPYp.test(false).test(point);
    };

    Predicate<Point>trapezoid = point -> {
      HalfPlane rightAC = HalfPlane.onTheRight(lineAC);
      HalfPlane rightPYp = HalfPlane.onTheRight(linePYp);
     return rectangle.test(false).test(point)
             && rightAC.test(true).test(point)
             && rightPYp.test(true).test(point);
    };

    Predicate<Point>triangleBCD = point -> rectangle.test(false).test(point)
            && trBCD.test(true).test(point);
    return leftHalfPlane
            .or(rightHalfPlaneLeftTriangle)
            .or(trapezoid)
            .or(triangleBCD);
  }

  static Predicate<Point> task3() {
    Point pP = Point.p(-1.5, 0);
    Point pA = Point.p(-2, 2);
    Point pB = Point.p(-1, 3);
    Point pC = Point.p(0, 1);
    Point pD = Point.p(-1, 2);
    Point pE = Point.p(-2, 1);
    Point pF = Point.p(0, 3);
    Point pQ = Point.p(-1.5, 2.5);
    Point pQ1 = Point.p(-0.5, 2.5);
    Point pK = Point.p(-1.5, 1.5);

    Line linePYp = Line.y(pP.x());
    Line lineEF = Line.l(pE, pF);
    Line lineAC = Line.l(pA, pC);
    Line lineAD = Line.l(pA, pD);
    Line lineBC = Line.l(pB, pC);
    Line lineBD = Line.l(pB, pD);
    Line lineQQ1 = Line.l(pQ, pQ1);

    Rectangle rectangleDF = Rectangle.r(pD, pF);
    Rectangle rectangleKQ1 = Rectangle.r(pK, pQ1);
    Rectangle rectangleED = Rectangle.r(pE, pD);

    Predicate<Point>triangleAroundA = point -> {
      HalfPlane leftAC = HalfPlane.onTheLeft(lineAC);
      HalfPlane leftPYp = HalfPlane.onTheLeft(linePYp);
      HalfPlane rightAD = HalfPlane.onTheRight(lineAD);
      return leftAC.test(false).test(point)
              && leftPYp.test(false).test(point)
              && rightAD.test(true).test(point);
    };

    Predicate<Point>triangleADB = point -> Triangle.t(pA, pB, pD).test(point);

    Predicate<Point>trapeziodUnderAC = point -> {
      HalfPlane rightAC = HalfPlane.onTheRight(lineAC);
      HalfPlane rightPYp = HalfPlane.onTheRight(linePYp);
      return rectangleED.test(point)
              && rightAC.test(false).test(point)
              && rightPYp.test(false).test(point);
    };

    Predicate<Point>triangleAroundB = point -> {
      HalfPlane rightBC = HalfPlane.onTheRight(lineBC);
      HalfPlane leftQQ1 = HalfPlane.onTheLeft(lineQQ1);
      return rectangleDF.test(point)
              && rightBC.test(false).test(point)
              && leftQQ1.test(false).test(point);
    };

    Predicate<Point>triangleAroundQ1 = point -> {
      HalfPlane leftBC = HalfPlane.onTheLeft(lineBC);
      HalfPlane rightQQ1 = HalfPlane.onTheRight(lineQQ1);
      return rectangleKQ1.test(false).test(point)
              && leftBC.test(false).test(point)
              && rightQQ1.test(false).test(point);
    };

    Predicate<Point>trapeziodAroundF = point -> {
      HalfPlane leftBC = HalfPlane.onTheLeft(lineBC);
      HalfPlane rightEF = HalfPlane.onTheRight(lineEF);
      return rectangleDF.test(point)
              && leftBC.test(false).test(point)
              && rightEF.test(false).test(point);
    };

    Predicate<Point>quadrantAroundD = point -> {
      HalfPlane rightAD = HalfPlane.onTheRight(lineAD);
      HalfPlane leftBD = HalfPlane.onTheLeft(lineBD);
      return rectangleKQ1.test(point)
              && rightAD.test(false).test(point)
              && leftBD.test(false).test(point);
    };
    return trapeziodUnderAC
            .or(triangleAroundA)
            .or(triangleADB)
            .or(triangleAroundB)
            .or(triangleAroundQ1)
            .or(trapeziodAroundF)
            .or(quadrantAroundD);
  }
}
