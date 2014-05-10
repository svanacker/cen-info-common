package org.cen.math;

import javax.vecmath.Vector2d;

import org.cen.geom.Point2D;

/**
 * Helper class for manipulating angles.
 */
public final class Angle {

    /**
     * Returns the angular distance between two angles.
     * 
     * @param angle1
     *            first angle in radians
     * @param angle2
     *            second angle in radians
     * @return the angular distance between the two angles in radians in the
     *         range [0 ; Pi]
     */
    public static double getDistance(double angle1, double angle2) {
        double d = Math.abs(angle1 - angle2);
        if (d > Math.PI) {
            d = Math.PI * 2 - d;
        }
        return d;
    }

    /**
     * Returns the mean value of an array of angles.
     * 
     * @param angles
     *            an array of angles
     * @return the mean value of the angles in radians in the range [0 ; 2 * Pi]
     */
    public static double getMean(double[] angles) {
        double mx = 0, my = 0;
        // Moyenne des vecteurs
        for (double a : angles) {
            mx += Math.cos(a);
            my += Math.sin(a);
        }
        double d = Math.atan2(my, mx);
        if (d < 0) {
            d += Math.PI * 2;
        }
        return d;
    }

    /**
     * Returns the angle between the segments [o, p1] and [o, p2]
     * 
     * @param o
     *            the origin
     * @param p1
     *            point 1
     * @param p2
     *            point 2
     * @return the angle p1,o,p2
     */
    public static double getPointsAngle(Point2D o, Point2D p1, Point2D p2) {
        double x = o.getX();
        double y = o.getY();
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
        Vector2d v1 = new Vector2d(x1 - x, y1 - y);
        Vector2d v2 = new Vector2d(x2 - x, y2 - y);
        return v1.angle(v2) * relativeCCW(x, y, x2, y2, x1, y1);
    }

    /**
     * COPIED FROM Line2D java Returns an indicator of where the specified point
     * {@code (px,py)} lies with respect to the line segment from
     * {@code (x1,y1)} to {@code (x2,y2)}. The return value can be either 1, -1,
     * or 0 and indicates in which direction the specified line must pivot
     * around its first end point, {@code (x1,y1)}, in order to point at the
     * specified point {@code (px,py)} .
     * <p>
     * A return value of 1 indicates that the line segment must turn in the
     * direction that takes the positive X axis towards the negative Y axis. In
     * the default coordinate system used by Java 2D, this direction is
     * counterclockwise.
     * <p>
     * A return value of -1 indicates that the line segment must turn in the
     * direction that takes the positive X axis towards the positive Y axis. In
     * the default coordinate system, this direction is clockwise.
     * <p>
     * A return value of 0 indicates that the point lies exactly on the line
     * segment. Note that an indicator value of 0 is rare and not useful for
     * determining colinearity because of floating point rounding issues.
     * <p>
     * If the point is colinear with the line segment, but not between the end
     * points, then the value will be -1 if the point lies "beyond
     * {@code (x1,y1)}" or 1 if the point lies "beyond {@code (x2,y2)}".
     * 
     * @param x1
     *            the X coordinate of the start point of the specified line
     *            segment
     * @param y1
     *            the Y coordinate of the start point of the specified line
     *            segment
     * @param x2
     *            the X coordinate of the end point of the specified line
     *            segment
     * @param y2
     *            the Y coordinate of the end point of the specified line
     *            segment
     * @param px
     *            the X coordinate of the specified point to be compared with
     *            the specified line segment
     * @param py
     *            the Y coordinate of the specified point to be compared with
     *            the specified line segment
     * @return an integer that indicates the position of the third specified
     *         coordinates with respect to the line segment formed by the first
     *         two specified coordinates.
     * @since 1.2
     */
    public static int relativeCCW(double x1, double y1, double x2, double y2, double px, double py) {
        x2 -= x1;
        y2 -= y1;
        px -= x1;
        py -= y1;
        double ccw = px * y2 - py * x2;
        if (ccw == 0.0) {
            // The point is colinear, classify based on which side of
            // the segment the point falls on. We can calculate a
            // relative value using the projection of px,py onto the
            // segment - a negative value indicates the point projects
            // outside of the segment in the direction of the particular
            // endpoint used as the origin for the projection.
            ccw = px * x2 + py * y2;
            if (ccw > 0.0) {
                // Reverse the projection to be relative to the original x2,y2
                // x2 and y2 are simply negated.
                // px and py need to have (x2 - x1) or (y2 - y1) subtracted
                // from them (based on the original values)
                // Since we really want to get a positive answer when the
                // point is "beyond (x2,y2)", then we want to calculate
                // the inverse anyway - thus we leave x2 & y2 negated.
                px -= x2;
                py -= y2;
                ccw = px * x2 + py * y2;
                if (ccw < 0.0) {
                    ccw = 0.0;
                }
            }
        }
        return (ccw < 0.0) ? -1 : ((ccw > 0.0) ? 1 : 0);
    }

    /**
     * Returns the variation of an array of angles.
     * 
     * @param angles
     *            an array of angles
     * @return the variation of the angles in radians in the range [0 ; Pi]
     */
    public static double getVariation(double[] angles) {
        double m = getMean(angles);
        double v = 0;
        for (double a : angles) {
            v += getDistance(m, a);
        }
        return v / angles.length;
    }
}
