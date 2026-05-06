"""
Python project configuration for code challenges.

This file helps configure the Python path and environment for running tests.
"""

import sys
from pathlib import Path

# Add the project root to the Python path
project_root = Path(__file__).parent.parent
sys.path.insert(0, str(project_root))
