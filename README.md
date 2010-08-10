Data Fueled Trace Toolkit
=========================

This is a general framework for tracing and analyzing program execution.

It operates in 2 modes:

 * First, by running as a separate daemon and receiving commands over a network
   connection which are then used to build up the datastructures, like the
   trace tree.
 * Secondly, by being embedded within a single process and allowing that process
   to build the relevant datastructures in place.

The user interface will be presented by embedding a web server within the daemon or the application which will serve up the user interface for searching, querying and analysis.

